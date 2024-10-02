package validation_service;

import entities.Customer;
import entities.ShoppingCart;

import java.util.List;

public class CustomerValidationService {
    private boolean validateEmail(String email, List<Customer> customers) {
        return customers.stream().noneMatch((s) -> s.getEmail().equals(email));
    }

    private boolean validateUsername(String username, List<Customer> customers) {
        return customers.stream().noneMatch((s) -> s.getUserName().equals(username));
    }

    private boolean validateUserId(int userId, List<Customer> customers) {
        return customers.stream().noneMatch((s) -> s.getUserId() == userId);
    }

    private boolean validateCart(ShoppingCart cart, List<Customer> customers) {
        return true;
    }


    public boolean validateCustomer(Customer customer, List<Customer> customers) {
        boolean result = this.validateUserId(customer.getUserId(), customers) &&
                this.validateEmail(customer.getEmail(), customers) &&
//                this.validateUsername(customer.getUserName(), customers) &&
                this.validateCart(customer.getCart(), customers);
        return result;
    }
}
