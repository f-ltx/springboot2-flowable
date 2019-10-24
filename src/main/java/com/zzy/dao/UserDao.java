package com.zzy.dao;

import com.zzy.entity.Role;
import com.zzy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserGuid(String userGuid);
}
