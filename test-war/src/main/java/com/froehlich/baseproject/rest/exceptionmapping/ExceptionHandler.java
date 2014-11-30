package com.froehlich.baseproject.rest.exceptionmapping;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Response response = createResponse(BAD_REQUEST, "Da ist wohl ein Fehler passiert...");
        return response;
    }

    private Response createResponse(Response.Status status, String message) {
        Response response = Response.status(status).type(MediaType.APPLICATION_XML)
                .entity("<error>" + message + "</error>").build();
        return response;
    }
}
