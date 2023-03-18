package com.example.demo.restapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@RequestMapping(path="/hello")
	public String greetings() {
		return "Hello world!!!";
	}
}
