package com.zzy.controller;

import com.alibaba.fastjson.JSON;
import com.zzy.common.Context;
import com.zzy.common.DateUtil;
import com.zzy.common.dto.Result;
import com.zzy.entity.Apply;
import com.zzy.entity.User;
import com.zzy.entity.Verification;
import com.zzy.entity.VerificationApply;
import com.zzy.service.UserService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


/**
 * @author litianxiang
 */
@Controller
public class ApplyController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/deploy")
    @ResponseBody
    public Result<String> deploy() {
        Boolean deployFlag = userService.deploy();
        if (deployFlag) {
            return Result.success("部署成功");
        }
        return Result.error("部署失败");
    }

    @RequestMapping(value = "/approveList")
    public String approveList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<Task> tasks = userService.approveList(Context.getUser(request));
        return "applyList";
    }

    @RequestMapping(value = "/applyList")
    public String applyList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        userService.findApplyList(Context.getUser(request));
        return "applyList";
    }

    @RequestMapping(value = "/apply")
    @ResponseBody
    public Result<String> apply(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String reason = request.getParameter("reason");
        Verification verification = new Verification(Long.parseLong(id), name, reason);
        Apply apply = new Apply();
        User user = Context.getUser(request);
        apply.setApplyUser(user);
        apply.setApplyUserId(user.getId());
        apply.setVerificationId(verification.getId());
        apply.setVerification(verification);
        String date = DateUtil.convertDateToString(new Date(), DateUtil.COMMON_FORMAT);
        apply.setTitle(date + "_" + user.getDisplayName());
        userService.apply(apply);
        return Result.success("申请成功");
    }

    @RequestMapping("/applyUI")
    public String applyUI(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "applyUI";
    }

    @RequestMapping("/loadVerificationData")
    @ResponseBody
    public Result<String> loadVerificationData(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<VerificationApply> verificationApplies = userService.loadVerificationData(Context.getUser(request));
        return Result.success(JSON.toJSONString(verificationApplies));
    }

}
