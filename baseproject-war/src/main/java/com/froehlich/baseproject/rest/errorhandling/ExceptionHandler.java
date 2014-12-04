package com.froehlich.baseproject.rest.errorhandling;

import org.slf4j.Logger;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by mfroehlich on 08.11.2014.
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Inject
    private Logger logger;

    @Override
    public Response toResponse(Throwable exception) {
        Response response = createResponse(BAD_REQUEST, "Da ist wohl ein Fehler passiert...");

        logger.error("Fehlermeldung im ExceptionHandler", exception);

        return response;
    }

    private Response createResponse(Response.Status status, String message) {
        Response response = Response.status(status).type(MediaType.APPLICATION_XML)
                .entity("<error>" + message + "</error>").build();
        return response;
    }
}
