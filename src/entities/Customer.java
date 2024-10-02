package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private ShoppingCart cart;
    private final List<Order> orders;

    {
        orders = new ArrayList<Order>();
    }

    public Customer(int userId, String userName, String email, String address) {
        super(userId, userName, email);
        this.address = address;
    }

    public Customer(User user, String address) {
        super(user);
        this.address = address;
        this.cart = new ShoppingCart();
    }

    public Customer(int userId, String userName, String email, String address, ShoppingCart cart, List<Order> orders) {
        super(userId, userName, email);
        this.address = address;
        this.cart = cart;
        this.orders.addAll(orders);
    }

    public Customer(User user, String address, ShoppingCart cart, List<Order> orders) {
        super(user);
        this.address = address;
        this.cart = cart;
        this.orders.addAll(orders);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-30s | %-40s |", getUserId(), getUserName(), getEmail(), getAddress());
    }

}
