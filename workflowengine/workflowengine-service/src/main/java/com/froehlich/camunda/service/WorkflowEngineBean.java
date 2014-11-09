package com.froehlich.camunda.service;

import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.cdi.annotation.ProcessEngineName;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Stateless
public class WorkflowEngineBean implements WorkflowEngineService {

    @Inject
    @ProcessEngineName("my-process-engine")
    private RuntimeService runtimeService;

    @Inject
    @ProcessEngineName("my-process-engine")
    private TaskService taskService;

    @Override
    public String startProcessInstanceByKey(String processKey) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey);
        return processInstance.getId();
    }

    @Override
    public void deleteProcessInstanceById(String processId) {
        runtimeService.deleteProcessInstance(processId, "No special reason!");
    }

    public Map<String, Object> loadVariablesByProcessId(String processId) {
        Execution execution = runtimeService.createExecutionQuery().processInstanceId(processId).singleResult();
        String executionId = execution.getId();
        Map<String, Object> variables = runtimeService.getVariables(executionId);
        return variables;
    }

    public String loadCurrentTaskIdByProcessId(String processId) {
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        String taskId = task != null ? task.getId() : null;
        return taskId;
    }

    public String loadCurrentTaskKeyByProcessId(String processId) {
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        String taskDefinitionKey = task != null ? task.getTaskDefinitionKey() : null;
        return taskDefinitionKey;
    }

    public void completeCurrentTaskOfProcess(String processId) {
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        taskService.complete(task.getId());
    }
}
