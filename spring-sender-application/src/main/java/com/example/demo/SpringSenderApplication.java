package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication

public class SpringSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSenderApplication.class, args);
	}

}
