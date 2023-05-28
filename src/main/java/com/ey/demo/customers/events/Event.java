package com.ey.demo.customers.events;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class Event <T>{

    private String id;
    private Date date;
    private EventType type;
    private T data;

}
