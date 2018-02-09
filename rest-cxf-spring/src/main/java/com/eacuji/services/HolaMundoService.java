package com.eacuji.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by eacuji on 08/02/2018.
 */
@Produces(MediaType.APPLICATION_JSON)
public interface HolaMundoService {

    @GET
    @Path(value="/hola1/{nombre}")
    public String holaMundo(@PathParam("nombre") String nombre);

}
