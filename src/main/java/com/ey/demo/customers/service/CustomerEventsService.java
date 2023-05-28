package com.ey.demo.customers.service;

import com.ey.demo.customers.entity.Customer;
import com.ey.demo.customers.events.CustomerCreatedEvent;
import com.ey.demo.customers.events.Event;
import com.ey.demo.customers.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventsService {

    @Autowired
    private KafkaTemplate<String, Object> producer;

    @Value("${topic.customer.name:customers}")
    private String topicCustomer;

    public void publish (Customer customer){

        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        customerCreatedEvent.setData(customer);
        customerCreatedEvent.setId(UUID.randomUUID().toString());
        customerCreatedEvent.setType(EventType.CREATED);
        customerCreatedEvent.setDate(new Date());

        this.producer.send(topicCustomer, customerCreatedEvent);
    }
}
