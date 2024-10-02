package services;

import entities.Customer;
import repositories.CustomerRepo;

import java.util.Scanner;

public class CustomerService {
    CustomerRepo customerRepo = new CustomerRepo();

    public void addCustomer(Scanner scanner) {
        System.out.println("Enter User Id : ");
        int userId = scanner.nextInt();
        System.out.println("Enter Username : ");
        String username = scanner.next();
        System.out.println("Enter Email : ");
        String email = scanner.next();
        System.out.println("Enter Address : ");
        String address = scanner.next();
        customerRepo.addCustomer(new Customer(userId, username, email, address));
    }

    public void getCustomer(int id) {
        System.out.printf("| %-10s | %-20s | %-30s | %-40s |%n", "User ID", "User Name", "Email", "Address");
        System.out.println("---------------------------------------------------------------------------------------------");
        var customer = customerRepo.getCustomer(id);
        System.out.println(customer);
    }

    public void getCustomers() {
        System.out.printf("| %-10s | %-20s | %-30s | %-40s |%n", "User ID", "User Name", "Email", "Address");
        System.out.println("---------------------------------------------------------------------------------------------");
        for(var customer : customerRepo.getCustomers()) {
            System.out.println(customer);
        }
    }

    public CustomerRepo getCustomerRepo() {
        return customerRepo;
    }
}
