package controllers;

import exceptions.InvalidProfileException;
import model.Customer;
import java.util.List;

/**
 * Control class for Manage Profile use case (UC-03)
 * @author yosef
 */
public class ManageProfileController {

 
    private Customer currentCustomer;

  
    public ManageProfileController(Customer customer) {
        this.currentCustomer = customer;
    }

    public Customer loadProfile(String customerId)
                               throws InvalidProfileException {

        if (currentCustomer == null) {
            throw new InvalidProfileException(
                "No customer data found."
            );
        }

        if (!currentCustomer.getCustomerId().equals(customerId)) {
            throw new InvalidProfileException(
                "Customer ID does not match."
            );
        }

        return currentCustomer;
    }

   
    public boolean validateInput(Customer customer)
                                throws InvalidProfileException {

        if (customer.getName() == null ||
            customer.getName().isEmpty())
            throw new InvalidProfileException(
                "Name cannot be empty."
            );

        if (customer.getEmail() == null ||
            !customer.getEmail().contains("@"))
            throw new InvalidProfileException(
                "Invalid email. Must contain '@'."
            );

        if (customer.getPhone() == null ||
            customer.getPhone().isEmpty())
            throw new InvalidProfileException(
                "Phone number cannot be empty."
            );

        if (customer.getAddress() == null ||
            customer.getAddress().isEmpty())
            throw new InvalidProfileException(
                "Address cannot be empty."
            );


        return true;
    }

  
    public boolean updateProfile(Customer customer)
                                throws InvalidProfileException {

        // Step 1: validate first
        validateInput(customer);

        // Step 2: update in-memory customer
        currentCustomer.setName(customer.getName());
        currentCustomer.setEmail(customer.getEmail());
        currentCustomer.setPhone(customer.getPhone());
        currentCustomer.setAddress(customer.getAddress());

        // Keep old password if new one is empty
        if (customer.getPassword() != null &&
            !customer.getPassword().isEmpty()) {
            currentCustomer.setPassword(customer.getPassword());
        }

        // Step 3: call entity method
        currentCustomer.updateProfile();

        return true;
    }

  
    public List<String> getOrderHistory(String customerId) {
        return currentCustomer.getOrderHistory();
    }


    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
}