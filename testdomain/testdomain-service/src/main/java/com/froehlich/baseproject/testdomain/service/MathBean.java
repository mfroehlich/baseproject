package com.froehlich.baseproject.testdomain.service;

import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Stateless
public class MathBean implements MathService {

    @Inject
    private Logger logger;

    public int addNumbers(int a, int b) {
        logger.debug("Adding numbers " + a + " + " + b);
        int sum = a + b;
        logger.debug("Sum of " + a + " + " + b + " is " + sum);
        return sum;
    }
}
