package com.zzy.dao;

import com.zzy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * @author litianxiang
 */
public interface RoleDao extends JpaRepository<Role, Long> {
    @Query(value = "SELECT * FROM T_ROLE R WHERE R.ID IN (SELECT ROLE_ID FROM T_USER_ROLE UR WHERE UR.USER_ID = ?1)",nativeQuery = true)
    Set<Role> findRolesByUserGuid(Long id);
}
