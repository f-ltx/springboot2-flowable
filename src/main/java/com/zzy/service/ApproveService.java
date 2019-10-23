package com.zzy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.flowable.task.api.Task;

import com.zzy.common.dto.HistoryLog;
import com.zzy.common.dto.TaskBean;

public interface ApproveService {
	
	
	public Map<String, Object> createLeave();
	
	
	public List<TaskBean> converTaskList(List<Task> list);
	
	
	public Map<String, Object> getTaskFormPropertyList(String taskId);
	
	
	public void submitFrom(String taskId, Map<String, Object> leaveParams);
	
    /**
     * 流程图
     * @param httpServletResponse
     * @param processId
     * @throws Exception
     */
    public void genProcessDiagram(HttpServletResponse httpServletResponse, String processId) throws Exception;
    
    public List<HistoryLog> historyDetail(String processId);

}
