package com.zzy.config.event;


import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CustormEvent implements FlowableEvent {

	protected FlowableEventType type;
	protected String executionId;
	protected String processInstanceId;
	protected String processDefinitionId;

	@Override
	public FlowableEventType getType() {
		return FlowableEngineEventType.CUSTOM;
	}

	public String getExecutionId() {
		return this.executionId;
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

	public String getProcessDefinitionId() {
		return this.processDefinitionId;
	}

	public CustormEvent(String executionId, String processInstanceId, String processDefinitionId) {
		super();
		this.executionId = executionId;
		this.processInstanceId = processInstanceId;
		this.processDefinitionId = processDefinitionId;
	}


	public static void main(String[] args) {
		CustormEvent event =new CustormEvent("1","2","3");
		log.info("---{}", event);
		
	}
	

}
