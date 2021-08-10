package com.example.snomate.controller;

import com.example.snomate.HelloWorldService;
import com.example.snomate.model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class HelloWorldController {

	@Autowired
	HelloWorldService helloWorldService;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		List<HelloWorldBean> helloWorldBeans = helloWorldService.testService();
		return "HelloWorld test";
	}
}
