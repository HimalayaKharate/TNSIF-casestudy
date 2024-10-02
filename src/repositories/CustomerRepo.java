package repositories;

import entities.Customer;
import validation_service.CustomerValidationService;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private final List<Customer> customers = new ArrayList<>();
    private CustomerValidationService validationService = new CustomerValidationService();

    public void addCustomer(Customer customer){
        if(validationService.validateCustomer(customer, this.customers)){
            customers.add(customer);
        }else {
            System.out.println("Invalid Customer");
        }
    }

    public Customer getCustomer(int id){
        return customers.stream().filter(customer -> customer.getUserId() == id).findFirst().orElse(null);
    }

    public List<Customer> getCustomers(){
        return customers;
    }

}
