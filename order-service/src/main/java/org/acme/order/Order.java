package org.acme.order;
import java.util.List;
public class Order {
    public Long id;
    public String customerName;
    public List<Long> dishIds; 
    public double total;      
    public Order() {}
    public Order(Long id, String customerName, List<Long> dishIds) {
        this.id = id;
        this.customerName = customerName;
        this.dishIds = dishIds;
    }
}