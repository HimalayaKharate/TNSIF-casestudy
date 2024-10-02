package services;

import entities.Order;
import entities.Product;
import repositories.CustomerRepo;
import repositories.OrderRepo;
import repositories.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    OrderRepo orderRepo = new OrderRepo();
    ProductRepo productRepo ;
    CustomerRepo customerRepo;
    public OrderService(ProductRepo repo, CustomerRepo cRepo) {
        this.productRepo = repo;
        this.customerRepo = cRepo;
    }


    public void placeOrder(Scanner scanner) {
        System.out.println("Enter order id : ");
        int orderId = scanner.nextInt();
        System.out.println("Enter Customer Id : ");
        int customerId = scanner.nextInt();
        System.out.println("Enter the products : ");
        int no = scanner.nextInt();
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < no; i++) {
            System.out.println("Enter product id : ");
            int productId = scanner.nextInt();
            products.add(productRepo.getProductById(productId));
        }
        orderRepo.add(new Order(orderId, customerRepo.getCustomer(customerId), products, Order.Status.PENDING));
    }

    public void updateOrderStatus(Scanner scanner) {
        System.out.println("Enter the id of the order you would like to update : ");
        int id = scanner.nextInt();
        System.out.println("Enter the status of the order you would like to update : ");
        String s= scanner.next();
        Order.Status st = Order.Status.PENDING;
        switch (s) {
            case "pending": st = Order.Status.PENDING; break;
            case "completed": st = Order.Status.COMPLETED; break;
            case "cancelled": st = Order.Status.CANCELLED; break;
            case "delayed" : st = Order.Status.DELAYED; break;
        }
        orderRepo.updateOrderStatus(id, st);
    }

    public void getOrder(int id){
        System.out.printf("| %-10s | %-10s | %-10s |%n", "Order ID", "Customer ID", "Status");
        System.out.println("-------------------------------------------------");
        System.out.println(orderRepo.getOrder(id));
    }

    public void listOrder() {
        System.out.printf("| %-10s | %-10s | %-10s |%n", "Order ID", "Customer ID", "Status");
        System.out.println("-------------------------------------------------");
        for (Order order : orderRepo.getOrders()) {
            System.out.println(order);
        }
    }
}
