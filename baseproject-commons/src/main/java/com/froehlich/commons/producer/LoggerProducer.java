package com.froehlich.commons.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Created by mfroehlich on 03.12.2014.
 */
public class LoggerProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Logger logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        return logger;
    }
}
