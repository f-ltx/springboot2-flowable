package com.zzy.config.event;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CustormEventListener implements FlowableEventListener{

	@Override
	public void onEvent(FlowableEvent event) {
		
		FlowableEventType eventType = event.getType();
		
		if(FlowableEngineEventType.CUSTOM.equals(eventType)) {
			log.info("自定义事件-----流程结束------{}",event);
		}
		
	}

	@Override
	public String getOnTransaction() {
		return null;
	}


	@Override
	public boolean isFailOnException() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFireOnTransactionLifecycleEvent() {
		// TODO Auto-generated method stub
		return false;
	}

}
