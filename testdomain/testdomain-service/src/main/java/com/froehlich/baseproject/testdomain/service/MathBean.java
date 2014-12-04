package com.froehlich.baseproject.testdomain.service;

import com.froehlich.commons.monitoring.interceptor.ExceptionLogging;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Stateless
@ExceptionLogging
public class MathBean implements MathService {

    @Inject
    private Logger logger;

    public int addNumbers(String a, String b) {
        logger.debug("Adding numbers " + a + " + " + b);
        int sum = new Integer(a) + new Integer(b);
        logger.debug("Sum of " + a + " + " + b + " is " + sum);
        return sum;
    }
}
