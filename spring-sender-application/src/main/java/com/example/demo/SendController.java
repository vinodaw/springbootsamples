package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    
    private static final String queue = "test-queue-jms";

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/messages")
    public String postMessage(@RequestParam String message) {
        jmsTemplate.send(queue, s -> s.createTextMessage(message));
        return message;
    }
}