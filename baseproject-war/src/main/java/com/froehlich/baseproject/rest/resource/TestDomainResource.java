package com.froehlich.baseproject.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.froehlich.baseproject.testdomain.service.TestDomainService;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Path("testdomain")
public class TestDomainResource {

    @Inject
    private TestDomainService testDomainService;

    @GET
    @Path("print/{string}")
    public String startProcessInstance(@PathParam("string") String outputString) {
        System.out.println("Output: " + outputString);
        return "Hello " + outputString;
    }
}
