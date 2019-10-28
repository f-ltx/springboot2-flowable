package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Description:
 *
 * @author litianxiang
 * @date 2019-10-25
 */
@Entity
@Table(name = "T_APPLY")
//@DynamicUpdate
//@DynamicInsert
public class Apply implements Serializable {
    private static final long serialVersionUID = -1799219185761562584L;
    private Long id;
    private String title;
    private Long applyUserId;
    private Long verificationId;
    private User applyUser;
    private Verification verification;
    private Set<Approve> approves;
    private Date applyDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    @Transient
    public User getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(User applyUser) {
        this.applyUser = applyUser;
    }

    @Transient
    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    @Transient
    public Set<Approve> getApproves() {
        return approves;
    }

    public void setApproves(Set<Approve> approves) {
        this.approves = approves;
    }
}
