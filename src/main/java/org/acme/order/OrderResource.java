package org.acme.order;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.List;

@Path("/orders")
public class OrderResource {
    @Inject
    OrderRepository repository;

    @GET
    public List<Order> getAll() { return repository.findAll(); }

    @POST
    public Order create(Order order) {
        repository.persist(order);
        return order;
    }
}
