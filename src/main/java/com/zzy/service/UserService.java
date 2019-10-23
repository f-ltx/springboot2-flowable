package com.zzy.service;

import com.zzy.dao.UserDao;
import com.zzy.dao.VerificationDao;
import com.zzy.entity.User;
import com.zzy.entity.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private VerificationDao verificationDao;

    public User login(String username, String password) {
        return userDao.findByUserGuid(username);
    }

    public List<Verification> loadVerificationData() {
        return verificationDao.findAll();
    }
}
