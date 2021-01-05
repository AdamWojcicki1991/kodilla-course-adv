package com.kodilla.kodillajms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @JmsListener(containerFactory = "jmsFactory", destination = "queue-test")
    public void receive(String message) {
        System.out.println("Received the message: " + message);
    }
}
