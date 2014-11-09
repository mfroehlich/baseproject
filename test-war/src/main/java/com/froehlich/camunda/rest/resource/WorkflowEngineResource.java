package com.froehlich.camunda.rest.resource;

import com.froehlich.camunda.service.WorkflowEngineService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Map;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Path("camunda")
public class WorkflowEngineResource {

    @Inject
    private WorkflowEngineService workflowEngineService;

    @GET
    @Path("startProcessInstance/{processKey}")
    public String startProcessInstance(@PathParam("processKey") String processKey) {
        String processInstanceId = workflowEngineService.startProcessInstanceByKey(processKey);
        return "Prozess gestartet: " + processInstanceId;
    }

    @GET
    @Path("deleteProcessInstance/{processId}")
    public String deleteProcessInstance(@PathParam("processId") String processId) {
        workflowEngineService.deleteProcessInstanceById(processId);
        return "Deleted ProcessInstance " + processId + " successfully.";
    }

    @GET
    @Path("loadStatusByProcessInstanceId/{processId}")
    public String loadStatusByProcessInstanceId(@PathParam("processId") String processId) {
        return getStatusString(processId);
    }

    @GET
    @Path("completeCurrentTaskOfProcess/{processId}")
    public String completeCurrentTaskOfProcess(@PathParam("processId") String processId) {
        workflowEngineService.completeCurrentTaskOfProcess(processId);
        String statusString = getStatusString(processId);
        return "Task completed<br><br>" + statusString;
    }

    private String getStatusString(String processId) {
        Map<String, Object> variablesMap = workflowEngineService.loadVariablesByProcessId(processId);
        String taskIdByProcessId = workflowEngineService.loadCurrentTaskIdByProcessId(processId);
        String taskDefinitionIdByProcessId = workflowEngineService.loadCurrentTaskKeyByProcessId(processId);

        StringBuilder s = new StringBuilder();
        for (String variableName : variablesMap.keySet()) {
            s.append(variableName + " : ").append(variablesMap.get(variableName)).append("<br>");
        }

        s.append("Current Task Id: " + taskIdByProcessId).append("<br>");
        s.append("Current Task Key: " + taskDefinitionIdByProcessId).append("<br>");

        return s.toString();
    }
}
