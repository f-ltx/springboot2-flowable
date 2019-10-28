package com.zzy.entity;

/**
 * Description:
 *
 * @author litianxiang
 * @date 2019-10-25
 */
public class VerificationApply {
    private Verification verification;
    private Apply apply;
    private Boolean hasApply;

    public VerificationApply(Verification verification, Apply apply, Boolean hasApply) {
        this.verification = verification;
        this.apply = apply;
        this.hasApply = hasApply;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Boolean getHasApply() {
        return hasApply;
    }

    public void setHasApply(Boolean hasApply) {
        this.hasApply = hasApply;
    }
}
