package com.zzy.common;

import com.zzy.entity.User;

import javax.servlet.http.HttpServletRequest;

public class Context {

    public static User getUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(SessionConst.SESSION_USER_KEY);
    }
}
