package com.froehlich.baseproject.rest.resource;

import com.froehlich.baseproject.service.MyEjbService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Map;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Path("resttest")
public class MyTestResource {

    @Inject
    private MyEjbService myEjbService;

}
