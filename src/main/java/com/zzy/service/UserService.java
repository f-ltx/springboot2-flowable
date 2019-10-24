package com.zzy.service;

import com.zzy.dao.RoleDao;
import com.zzy.dao.UserDao;
import com.zzy.dao.VerificationDao;
import com.zzy.entity.*;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
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

    public User login(String username, String password) {
        return userDao.findByUserGuid(username);
    }

    public List<Verification> loadVerificationData() {
        return verificationDao.findAll();
    }

    public void apply(Verification verification, User user) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("verification", verification);
        variables.put("assigne", user.getUserGuid());
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("ldmsProcess", variables);
        Task task = taskService.createTaskQuery().taskAssignee(user.getUserGuid()).processInstanceId(pi.getId()).singleResult();
        variables.put("sp", "sp");
        taskService.complete(task.getId(), variables);
    }

    public List<TaskVerification> applyList(User user) {
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskAssignee(user.getUserGuid());
        taskQuery.orderByTaskCreateTime().asc();
        List<Task> tasks = taskQuery.list();
        List<TaskVerification> taskVerifications = new ArrayList<>();
        for (Task task : tasks) {
            Verification verification = (Verification) taskService.getVariable(task.getId(), "verification");
            taskVerifications.add(new TaskVerification(task, verification));
        }

        List<HistoricTaskInstance> list1 = historyService.createHistoricTaskInstanceQuery().taskAssignee(user.getUserGuid()).list();
        List<HistoricActivityInstance> list2 = historyService.createHistoricActivityInstanceQuery().taskAssignee(user.getUserGuid()).list();
        List<HistoricProcessInstance> list3 = historyService.createHistoricProcessInstanceQuery().startedBy(user.getUserGuid()).list();
        return taskVerifications;
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
}
