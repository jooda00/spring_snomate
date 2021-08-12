package com.example.snomate.controller;

import com.example.snomate.model.Project;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.repository.ProjectRepository;
import com.example.snomate.repository.TestRepository;
import com.example.snomate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// 예시2 - select
	@GetMapping(path = "/test")
	public List<Test> selectTest() {
		return testRepository.findAll();
	}
	@GetMapping(path = "/test/{id}")
	public Test selectTestFromId(@PathVariable("id") long id) {
		return testRepository.findById(id);
	}
	@GetMapping(path="/user/{email}") // 만약 검색 타입이 String으로 겹칠 경우 /user/email/{email}, /user/name/{name}으로 분리할 수 있습니다.
	public String userTest(@PathVariable("email") String email) {
		return email;
	}
	// insert
	@PostMapping(path = "/test")
	public Test insertTest(@RequestBody Test test) {
		return testRepository.save(test);
	}
	// update
	@PutMapping(path = "/test")
	public Test updateTest(@RequestBody Test test) {
		return testRepository.save(test);
	}
	// delete
	@DeleteMapping(path="/test/{id}")
	public Test deleteTestFromId(@PathVariable("id") long id) {
		Test test = testRepository.findById(id);
		test.setUseNow(false);
		return testRepository.save(test);
		//return test;
	}
	
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	@PostMapping(path = "/users")
	public User saveUsers(@RequestBody User user) {
		return userRepository.save(user);
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