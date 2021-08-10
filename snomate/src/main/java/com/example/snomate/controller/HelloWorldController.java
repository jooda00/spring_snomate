package com.example.snomate.controller;

import com.example.snomate.model.Test;
import com.example.snomate.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {
	@Autowired
	private TestRepository testRepository;

	
	@GetMapping(path = "/test")
	public List<Test> getTest() {
		return testRepository.findAll();
	}
	
	@PostMapping(path = "/save")
	public Test save(@RequestBody Test test) {
		return testRepository.save(test);
	}
}
