package org.acme.order;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.acme.order.client.MenuClient;
import org.acme.order.client.DishDTO;
import java.util.List;

@Path("/orders")
public class OrderResource {
    @Inject
    OrderRepository repository;
    @Inject
    @RestClient
    MenuClient menuClient; 

    @GET
    public List<Order> getAll() { return repository.findAll(); }

    @POST
    public Order create(Order order) {
        double sum = 0;
        if (order.dishIds != null) {
            for (Long dishId : order.dishIds) {
                try {
                    DishDTO dish = menuClient.getDishById(dishId);
                    sum += dish.price;
                } catch (Exception e) {
                    System.out.println("Error fetching dish: " + dishId);
                }
            }
        }
        order.total = sum;
        repository.persist(order);
        return order;
    }
}