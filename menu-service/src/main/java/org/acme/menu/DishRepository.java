package org.acme.menu;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@ApplicationScoped
public class DishRepository {
    private List<Dish> dishes = new ArrayList<>();
    public DishRepository() {
        dishes.add(new Dish(1L, "Margarita", "Pizza", 150.00));
        dishes.add(new Dish(2L, "Pepperoni", "Pizza", 180.00));
        dishes.add(new Dish(3L, "Philadelphia", "Sushi", 220.00));
        dishes.add(new Dish(4L, "Borsch", "Soup", 90.00));
        dishes.add(new Dish(5L, "Cola", "Drink", 30.00));
    }
    public List<Dish> findAll() { return dishes; }
    public Optional<Dish> findById(Long id) {
        return dishes.stream().filter(d -> d.id.equals(id)).findFirst();
    }
    public Dish findRandom() {
        return dishes.get(new Random().nextInt(dishes.size()));
    }
}
