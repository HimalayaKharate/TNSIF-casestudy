package validation_service;

import entities.Order;

import java.util.List;

public class OrderValidationService {
    public boolean validateOrder(Order order, List<Order> orders) {
        return orders.stream().noneMatch((order1)-> order.getOrderId() == order1.getOrderId());
    }
}
