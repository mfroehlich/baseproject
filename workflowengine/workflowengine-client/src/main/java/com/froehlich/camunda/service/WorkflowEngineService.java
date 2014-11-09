package com.froehlich.camunda.service;

import java.util.Map;

/**
 * Created by mfroehlich on 08.11.2014.
 */
public interface WorkflowEngineService {

    public String startProcessInstanceByKey(String processKey);

    public void deleteProcessInstanceById(String processId);

    public Map<String, Object> loadVariablesByProcessId(String processId);

    public String loadCurrentTaskIdByProcessId(String processId);

    public String loadCurrentTaskKeyByProcessId(String processId);

    public void completeCurrentTaskOfProcess(String processId);
}
