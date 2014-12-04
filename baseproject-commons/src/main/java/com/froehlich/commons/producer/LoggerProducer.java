package com.froehlich.commons.producer;

import com.froehlich.commons.monitoring.entity.ErrorCollectingLogger;
import com.froehlich.commons.monitoring.service.ErrorCollectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 * Created by mfroehlich on 03.12.2014.
 */
public class LoggerProducer {

    @Inject
    private ErrorCollectorService errorCollectorService;

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Logger logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        ErrorCollectingLogger errorCollectingLogger = new ErrorCollectingLogger(logger, errorCollectorService);
        return errorCollectingLogger;
    }
}
