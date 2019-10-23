package com.zzy.common.dto;

import java.util.Date;
import java.util.List;

import org.flowable.engine.task.Comment;

import lombok.Data;

@Data
public class HistoryLog {
	
	private String taskId;
	
	private String parentTaskId;

	private String name;

	private String processInstanceId;

	private String executionId;

	private Date createTime;

	private Date endTime;

	private String approveUserName;
	
	private List<Comment> comments;

}
