package org.spring.customermanagementapplication.customermanagementapplication.api;

import org.spring.customermanagementapplication.customermanagementapplication.model.Customer;
import org.spring.customermanagementapplication.customermanagementapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public List<Customer> getCustomer() {
        return customerService.getCustomerList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer customer) {
        return customerService.updateCustomerList(customerId, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomerList(customerId);
    }
}
