package com.zzy.dao;

import com.zzy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * @author litianxiang
 */
public interface RoleDao extends JpaRepository<Role, Long> {
    @Query(value = "select * from t_role r where r.id in (select role_id from t_user_role ur where ur.user_id = ?1)",nativeQuery = true)
    Set<Role> findRolesByUserGuid(Long id);
}
