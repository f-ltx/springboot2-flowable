package com.zzy.controller;

import com.alibaba.fastjson.JSON;
import com.zzy.common.Context;
import com.zzy.common.SessionConst;
import com.zzy.common.dto.Result;
import com.zzy.entity.TaskVerification;
import com.zzy.entity.User;
import com.zzy.entity.Verification;
import com.zzy.service.UserService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author litianxiang
 */
@Controller
public class ApplyController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/approveList")
    public String approveList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<Task> tasks = userService.approveList(Context.getUser(request));
        return "applyList";
    }

    @RequestMapping(value = "/applyList")
    public String applyList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<TaskVerification> taskVerifications = userService.applyList(Context.getUser(request));
        modelMap.put("taskVerifications", taskVerifications);
        return "applyList";
    }

    @RequestMapping(value = "/apply")
    @ResponseBody
    public Result<String> apply(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String reason = request.getParameter("reason");
        Verification verification = new Verification(Long.parseLong(id), name, reason);
        userService.apply(verification, Context.getUser(request));
        return Result.success("申请成功");
    }

    @RequestMapping("/applyUI")
    public String applyUI(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "applyUI";
    }

    @RequestMapping("/loadVerificationData")
    @ResponseBody
    public String loadVerificationData(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<Verification> verifications = userService.loadVerificationData();
        return JSON.toJSONString(verifications);
    }

}
