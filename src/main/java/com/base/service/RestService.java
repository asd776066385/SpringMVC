package com.base.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testRest")
@Produces(MediaType.APPLICATION_JSON)
public interface RestService {

    // 访问地址 http://localhost:9090/springmvc/services/restService/testRest/status
    @GET
    @Path("/status")
    String getStatus();
}
