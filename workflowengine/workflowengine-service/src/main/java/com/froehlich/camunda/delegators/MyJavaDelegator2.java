package com.froehlich.camunda.delegators;

/**
 * Created by mfroehlich on 08.11.2014.
 */

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * Created by mfroehlich on 07.11.2014.
 */
public class MyJavaDelegator2 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String executionId = delegateExecution.getId();
        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();
        runtimeService.setVariable(executionId, "finish", "true");
    }
}
