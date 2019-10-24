package com.zzy.entity;

import org.flowable.task.api.Task;

/**
 * @author litianxiang
 */
public class TaskVerification {
    private Task task;
    private Verification verification;

    public TaskVerification() {
    }

    public TaskVerification(Task task, Verification verification) {
        this.task = task;
        this.verification = verification;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }
}
