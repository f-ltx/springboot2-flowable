package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description:
 *
 * @author litianxiang
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 6128701914371517901L;
    private Long id;
    private String userGuid;
    private String allPathName;
    private String displayName;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getAllPathName() {
        return allPathName;
    }

    public void setAllPathName(String allPathName) {
        this.allPathName = allPathName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Transient
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
