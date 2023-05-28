package com.ey.demo.customers.controller;

import com.ey.demo.customers.entity.Customer;
import com.ey.demo.customers.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        super();
        this.customerService = customerService;
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){

        return this.customerService.save(customer);
    }
}
