package entities;

import java.util.List;

public class Order {
    public enum Status{
            PENDING("P"), COMPLETED("CM"), CANCELLED("CN"), DELAYED("D");
            final String initials;
            Status(String initials){
                this.initials = initials;
            }

        public String getInitials() {
            return initials;
        }
    }

    private int orderId;
    private int customerId;
    private List<Product> products;
    private Status status;

    public Order() {
    }

    public Order(int orderId, Customer customer, List<Product> products, Status status) {
        this.orderId = orderId;
        this.customerId = customer.getUserId();
        this.products = products;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        for (Product product : products) {
            productDetails.append(product).append("\n");
        }

        return String.format("| %-10d | %-10d | %-10s |\n", orderId, customerId, status.getInitials()) + productDetails.toString();
    }

}
