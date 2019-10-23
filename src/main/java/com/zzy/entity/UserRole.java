package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author litianxiang
 */
@Entity
@Table(name = "T_USER_ROLE")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 8639954077137331245L;
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
