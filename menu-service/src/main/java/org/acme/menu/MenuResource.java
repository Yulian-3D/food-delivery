package org.acme.menu;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;

@Path("/menu")
public class MenuResource {
    @Inject
    DishRepository repository;
    @GET
    public List<Dish> getAll() { return repository.findAll(); }
    @GET
    @Path("/{id}")
    public Dish getOne(@PathParam("id") Long id) {
        return repository.findById(id).orElse(null);
    } 
    @GET
    @Path("/random")
    public Dish getRandom() { return repository.findRandom(); }
}
