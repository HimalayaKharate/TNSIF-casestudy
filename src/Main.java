import entities.Product;
import menu.MenuUtils;
import services.AdminService;
import services.CustomerService;
import services.OrderService;
import services.ProductService;

import java.util.Scanner;

public class Main {
    static OrderService orderService;
    static AdminService adminService = new AdminService();
    static CustomerService customerService = new CustomerService();
    static ProductService productService = new ProductService();

    static{
        orderService= new OrderService(productService.getProductRepo(), customerService.getCustomerRepo());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            MenuUtils.printMainMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1 ->{
                    boolean flag = true;
                    do {
                        MenuUtils.printAdminMenu();
                        int choice1 = sc.nextInt();
                        switch (choice1){
                            case 1->{
                                productService.addProduct(sc);
                            }
                            case 2->{
                                System.out.println("Enter the id of the Product to be deleted : ");
                                productService.removeProduct(sc.nextInt());
                            }
                            case 3->{
                                productService.listProducts();
                            }
                            case 4->{
                                adminService.add(sc);
                            }
                            case 5 -> {
                                adminService.getAdmins();
                            }
                            case 6->{
                                orderService.updateOrderStatus(sc);
                            }
                            case 7->{
                                orderService.listOrder();
                            }
                            case 8 ->{
                                System.out.println("Exiting Admin....");
                                flag = false;
                            }

                            default -> {
                                System.out.println("Invalid choice");
                            }
                        }
                    }while(flag);
                }
                case 2 ->{
                    boolean flag = true;
                    do{
                        MenuUtils.printCustomerMenu();
                        int choice1 = sc.nextInt();
                        switch(choice1){
                            case 1->{
                                customerService.addCustomer(sc);
                            }
                            case 2 -> {
                                customerService.getCustomers();
                            }
                            case 3 -> {
                                orderService.placeOrder(sc);
                            }

                            case 4 -> {
                                orderService.listOrder();
                            }
                            case 5 -> {
                                productService.listProducts();
                            }
                            case 6 -> {
                                System.out.println("Returning to Main Menu");
                                flag = false;
                            }
                        }
                    }while(flag);

                }
                case 3 ->{
                    System.out.println("You have Exited form the System.");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
}