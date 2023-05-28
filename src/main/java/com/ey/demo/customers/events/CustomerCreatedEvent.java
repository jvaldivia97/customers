package com.ey.demo.customers.events;

import com.ey.demo.customers.entity.Customer;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<Customer>{

}
