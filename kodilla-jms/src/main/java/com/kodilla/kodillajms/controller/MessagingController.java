package com.kodilla.kodillajms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessagingController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/process")
    public void processMessage(@RequestParam String message) {
        jmsTemplate.convertAndSend("queue-test", message);
    }
}
