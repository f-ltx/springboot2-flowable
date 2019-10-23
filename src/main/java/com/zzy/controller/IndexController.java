package com.zzy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzy.entity.User;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzy.common.SessionConst;
import com.zzy.common.dto.Result;


/**
 * @author guokaige
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index0(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    @RequestMapping("/login/action.json")
    @ResponseBody
    public Result<String> loginAction(ModelMap modelMap, HttpServletRequest request,
                                      HttpServletResponse response, HttpSession session, String username, String password) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute(SessionConst.SESSION_USERNAME_KEY, username);
            session.setAttribute(SessionConst.SESSION_USER_KEY, user);
            return Result.success("登陆成功");
        }
        return Result.error("登陆失败");
    }

    @RequestMapping("/login/out")
    public String loginOut(ModelMap modelMap, HttpServletRequest request,
                           HttpServletResponse response, HttpSession session, String username, String password) {
        session.setAttribute(SessionConst.SESSION_USERNAME_KEY, null);
        session.invalidate();
        return "login";
    }

}
