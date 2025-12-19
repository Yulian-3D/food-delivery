package org.acme.order.client;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/menu")
@RegisterRestClient(configKey = "menu-api")
public interface MenuClient {
    @GET
    @Path("/{id}")
    DishDTO getDishById(@PathParam("id") Long id);
}