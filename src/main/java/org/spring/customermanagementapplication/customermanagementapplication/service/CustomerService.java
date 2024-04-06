package org.spring.customermanagementapplication.customermanagementapplication.service;

import org.spring.customermanagementapplication.customermanagementapplication.dao.CustomerDAO;
import org.spring.customermanagementapplication.customermanagementapplication.exception.CustomerNotFoundException;
import org.spring.customermanagementapplication.customermanagementapplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }
    public List<Customer> getCustomerList() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
        return optionalCustomer.get();
    }

    public Customer updateCustomerList(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }
    public void deleteCustomerList(int customerId) {
        customerDAO.deleteById(customerId);
    }
}
