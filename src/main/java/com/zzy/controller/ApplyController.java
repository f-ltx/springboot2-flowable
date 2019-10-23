package com.zzy.controller;

import com.alibaba.fastjson.JSON;
import com.zzy.common.SessionConst;
import com.zzy.common.dto.Result;
import com.zzy.entity.User;
import com.zzy.entity.Verification;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/apply")
    public String apply(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "apply";
    }

    @RequestMapping("/loadVerificationData")
    @ResponseBody
    public String loadVerificationData(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        List<Verification> verifications = userService.loadVerificationData();
        return JSON.toJSONString(verifications);
    }

}
