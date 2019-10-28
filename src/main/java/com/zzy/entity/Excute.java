package com.zzy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author litianxiang
 * @date 2019-10-25
 */
@Entity
@Table(name = "T_EXCUTE")
public class Excute implements Serializable {
    private static final long serialVersionUID = -2132400843769158923L;
    private Long id;
    private String title;
    private Long excuteUserId;
    private User excuteUser;
    private Long applyId;
    private Apply apply;
    private Date excuteDate;

    public Date getExcuteDate() {
        return excuteDate;
    }

    public void setExcuteDate(Date excuteDate) {
        this.excuteDate = excuteDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getExcuteUserId() {
        return excuteUserId;
    }

    public void setExcuteUserId(Long excuteUserId) {
        this.excuteUserId = excuteUserId;
    }

    @Transient
    public User getExcuteUser() {
        return excuteUser;
    }

    public void setExcuteUser(User excuteUser) {
        this.excuteUser = excuteUser;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    @Transient
    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }
}
