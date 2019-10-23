package com.zzy.service;

import com.zzy.dao.UserDao;
import com.zzy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(String username, String password) {
        User user = userDao.findByUserGuid(username);
        if (user != null) {
            return true;
        }
        return false;
    }
}
