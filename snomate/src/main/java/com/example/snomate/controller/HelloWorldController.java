package com.example.snomate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "HelloWorld test";
	}
}
