package com.ey.demo.customers.service;

import com.ey.demo.customers.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerEventsService customerEventsService;

    public CustomerService(CustomerEventsService customerEventsService){
        super();
        this.customerEventsService = customerEventsService;
    }

    public Customer save(Customer customer){


        this.customerEventsService.publish(customer);
        System.out.println("Mensaje recibido: " + customer);

        return customer;
    }
}
