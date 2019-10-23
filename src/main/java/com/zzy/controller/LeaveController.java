package com.zzy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.zzy.common.SessionConst;
import com.zzy.common.dto.Result;
import com.zzy.common.dto.TaskBean;
import com.zzy.service.LeaveService;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    LeaveService leaveService;

    @Autowired
    TaskService taskService;


    @RequestMapping(value = "/login.json")
    @ResponseBody
    public Result<String> login(HttpSession session, String username) {
        session.setAttribute(SessionConst.SESSION_USERNAME_KEY, username);
        return Result.success("success");
    }

    @RequestMapping(value = "/create.json")
    @ResponseBody
    public Result<String> create() {
        Map<String, Object> map = leaveService.createLeave();
        String taskId = (String) map.get("taskId");
        return Result.success(taskId);
    }


    @RequestMapping(value = "/apply/task.json")
    @ResponseBody
    public Result<String> applyTask(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String username = (String) session.getAttribute(SessionConst.SESSION_USERNAME_KEY);
        List<Task> list = taskService.createTaskQuery().taskCandidateUser(username).listPage(0, 1);
        System.out.println(list.size() + "-------------------------------------------");
        if (null != list && !list.isEmpty()) {
            Task task = list.get(0);
            taskService.claim(task.getId(), username);
        }
        return Result.success("1");
    }

    @RequestMapping(value = "/all/task.json")
    @ResponseBody
    public Result<List<TaskBean>> allTask(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<Task> tasks = taskService.createTaskQuery().listPage(0, 1);
        List<TaskBean> beanlist = leaveService.converTaskList(tasks);
        return Result.success(beanlist);
    }


    @RequestMapping(value = "/task/list.json")
    @ResponseBody
    public Result<List<TaskBean>> taskList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        String assignee = (String) request.getSession().getAttribute(SessionConst.SESSION_USERNAME_KEY);
        List<Task> tasks = taskService// 与任务相关的Service
                .createTaskQuery()// 创建一个任务查询对象
                .taskAssignee(assignee)
                .list();

        List<TaskBean> list = leaveService.converTaskList(tasks);
        return Result.success(list);
    }


    @RequestMapping(value = "/handle/task.json")
    @ResponseBody
    public Result<String> handleTask(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {

        String taskId = request.getParameter("taskId");
        String reason = request.getParameter("reason");
        String count = request.getParameter("count");

        String tlMsg = request.getParameter("tlMsg");
        String tlApprove = request.getParameter("tlApprove");

        Map<String, Object> leaveParams = Maps.newHashMap();
        leaveParams.put("reason", reason);
        leaveParams.put("count", count);
        leaveParams.put("taskId", taskId);

        leaveParams.put("tlMsg", tlMsg);
        leaveParams.put("tlApprove", tlApprove);

        leaveService.submitFrom(taskId, leaveParams);
        return Result.success("1");
    }

}
