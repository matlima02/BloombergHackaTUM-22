package src.main.java.com.example.soundx.service;

import src.main.java.com.example.soundx.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> getAllCustomers();
}
