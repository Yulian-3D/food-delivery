package org.acme.menu;
public class Dish {
    public Long id;
    public String name;
    public String category;
    public double price;
    public Dish() {}
    public Dish(Long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
