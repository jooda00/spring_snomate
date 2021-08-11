package com.example.snomate.controller;

import com.example.snomate.model.Project;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.repository.ProjectRepository;
import com.example.snomate.repository.TestRepository;
import com.example.snomate.repository.UserRepository;

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

	@Autowired // 의존성 주입
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/test")
	public List<Test> getTest() {
		return testRepository.findAll();
	}
	
	@PostMapping(path = "/save")
	public Test save(@RequestBody Test test) {
		return testRepository.save(test);
	}
	
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/projects")
	public List<Project> getProjects(){
		return projectRepository.findAll();
	}
	
	@PostMapping(path = "/projects")
	public Project saveProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
}