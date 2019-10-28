package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description:
 *
 * @author litianxiang
 * @date 2019-10-25
 */
@Entity
@Table(name = "T_USER_ROLE")
public class UserRole implements Serializable {
    private static final long serialVersionUID = -7404634884556487069L;
    private Long id;
    private Long userId;
    private Long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
