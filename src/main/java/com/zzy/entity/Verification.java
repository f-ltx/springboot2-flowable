package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author litianxiang
 */
@Entity
@Table(name = "T_VERIFICATION")
public class Verification implements Serializable {
    private static final long serialVersionUID = -5330622721227597992L;
    private Long id;
    private String name;
    private String reason;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
