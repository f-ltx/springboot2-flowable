package com.zzy.dao;

import com.zzy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserGuid(String userGuid);
}
