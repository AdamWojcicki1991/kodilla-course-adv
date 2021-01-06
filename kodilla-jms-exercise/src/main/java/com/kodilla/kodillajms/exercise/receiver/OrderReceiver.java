package com.kodilla.kodillajms.exercise.receiver;

import com.kodilla.kodillajms.exercise.domain.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
    @JmsListener(containerFactory = "jmsFactory", destination = "order-queue")
    public void receive(Order order) {
        System.out.println("Receive order: " + order);
    }
}
