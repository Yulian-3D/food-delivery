package org.acme.order;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public OrderRepository() {
        orders.add(new Order(1L, "Test Client", List.of(1L, 2L)));
    }
    public List<Order> findAll() { return orders; }
    public Optional<Order> findById(Long id) {
        return orders.stream().filter(o -> o.id.equals(id)).findFirst();
    }
    public void persist(Order order) {
        order.id = (long) (orders.size() + 1);
        orders.add(order);
    }
}