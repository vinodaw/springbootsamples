package com.in28minutes.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.bean.Limits;
import com.in28minutes.microservices.configuration.LimitsConfig;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfig config;
	
	@GetMapping("/limits")
	public Limits getLimits() {
		return new Limits(config.getMinimum(),config.getMaximum());
	}

}
