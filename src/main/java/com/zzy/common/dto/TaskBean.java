package com.zzy.common.dto;

import java.util.Date;

import lombok.Data;


@Data
public class TaskBean {

	private String taskId;

	private String name;

	private String processInstanceId;

	private String executionId;
	
	private String processDefinitionId;

	private Date createTime;

	private Date endTime;

	private String approveUserName;

}
