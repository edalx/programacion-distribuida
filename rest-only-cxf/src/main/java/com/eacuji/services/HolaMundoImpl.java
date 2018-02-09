package com.eacuji.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;

@Path("/")
@Api
public class HolaMundoImpl {
	
	@GET
	@Path(value="/holamundo/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String holaMundo( @PathParam("nombre") String nombre ) {
		
		return "Hola " + nombre;
	}
}
