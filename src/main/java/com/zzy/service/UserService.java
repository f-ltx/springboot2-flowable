package com.zzy.service;

import com.zzy.dao.ApplyDao;
import com.zzy.dao.RoleDao;
import com.zzy.dao.UserDao;
import com.zzy.dao.VerificationDao;
import com.zzy.entity.*;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author litianxiang
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private VerificationDao verificationDao;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ApplyDao applyDao;

    public User login(String username, String password) {
        return userDao.findByUserGuid(username);
    }

    public List<VerificationApply> loadVerificationData(User user) {
        List<Verification> verifications = verificationDao.findAll();
        List<VerificationApply> vfas = new ArrayList<>();
        for (Verification verification : verifications) {
            List<Apply> applys = applyDao.findByVerificationIdAAndApplyUserId(verification.getId(), user.getId());
            Apply apply = applys != null && applys.size() > 0 ? applys.get(0) : null;
            Boolean hasApply = applys != null && applys.size() > 0;
            vfas.add(new VerificationApply(verification, apply, hasApply));
        }
        return vfas;
    }

    @Transactional(rollbackFor = Exception.class)
    public void apply(Apply apply) {
        applyDao.save(apply);
        Map<String, Object> variables = new HashMap<>();
        variables.put("apply", apply);
        variables.put("applyUserId", apply.getApplyUser().getUserGuid());
        variables.put("verificationId", apply.getVerificationId());
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("ldmsProcess", variables);
        Task task = taskService.createTaskQuery().taskAssignee(apply.getApplyUser().getUserGuid()).processInstanceId(pi.getId()).singleResult();
        taskService.complete(task.getId(), variables);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Task> approveList(User user) {
        Set<Role> roles = roleDao.findRolesByUserGuid(user.getId());
        user.setRoles(roles);
        List<String> groups = new ArrayList<>();
        for (Role role : roles) {
            groups.add(role.getCodeName());
        }
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateGroupIn(groups);
        List<Task> tasks = taskQuery.list();
        return tasks;
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean deploy() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.name("离岛免税核销流程");
        deploymentBuilder.addClasspathResource("processes/ldmsProcess.bpmn");
        Deployment deploy = deploymentBuilder.deploy();
        return deploy != null;
    }

    public List<Apply> findApplyList(User user) {
        List<Apply> applies = applyDao.findAllByApplyUserId(user.getId());
        return applies;
    }
}
