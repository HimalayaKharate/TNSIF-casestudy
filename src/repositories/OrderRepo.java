package repositories;

import entities.Order;
import validation_service.OrderValidationService;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private List<Order> orders = new ArrayList<Order>();
    OrderValidationService validationService = new OrderValidationService();
    public void add(Order order){
        if(validationService.validateOrder(order, orders)){
            orders.add(order);
        }else {
            System.out.println("Invalid order");
        }
    }


    public void updateOrderStatus(int orderId, Order.Status status){
        //find the order
        Order order = getOrder(orderId);
        //change the status
        if(order != null)
            order.setStatus(status);
        else System.out.println("Order not found");
    }

    public Order getOrder(int orderId){
        return orders.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
    }

    public List<Order> getOrders(){
        return orders;
    }
}
