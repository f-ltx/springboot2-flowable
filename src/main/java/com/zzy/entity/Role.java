package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Administrator
 */
@Entity
@Table(name = "T_ROLE")
public class Role implements Serializable {
    private static final long serialVersionUID = 4729745556865743855L;
    private Long id;
    private String roleId;
    private String codeName;
    private String roleName;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Transient
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
