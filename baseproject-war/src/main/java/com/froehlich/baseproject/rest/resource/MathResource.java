package com.froehlich.baseproject.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.froehlich.baseproject.testdomain.service.MathService;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Path("math")
public class MathResource {

    @Inject
    private MathService mathService;

    @GET
    @Path("add/{summand1}/{summand2}")
    public String add(@PathParam("summand1") String summand1, @PathParam("summand2") String summand2) {
        int sum = mathService.addNumbers(new Integer(summand1), new Integer(summand2));
        return "Sum of " + summand1 + " and " + summand2 + " is " + sum;
    }
}
