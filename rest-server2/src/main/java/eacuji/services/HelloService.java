package eacuji.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by eacuji on 31/01/2018.
 */

@Path("/greeter")
@Produces({MediaType.APPLICATION_JSON})
public interface HelloService {
    @GET
    @Path("/hello/{fileName}")
    public String helloWorld(@PathParam("fileName") String nombre);

}
