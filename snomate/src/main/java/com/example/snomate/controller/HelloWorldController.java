package com.example.snomate.controller;

import com.example.snomate.model.CategoryFirst;
import com.example.snomate.model.Project;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.model.UserLike;
import com.example.snomate.repository.CategoryFirstRepository;
import com.example.snomate.repository.ProjectRepository;
import com.example.snomate.repository.TestRepository;
import com.example.snomate.repository.UserLikeRepository;
import com.example.snomate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class HelloWorldController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private UserLikeRepository userLikeRepository;
	
	

//	@GetMapping(path = "/users")
//	public List<User> getUsers(){
//		return userRepository.findAll();
//	}
	
	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable("id") int id){
		User user = userRepository.findById(id);
		user.setUserPassword(null);
		user.setUserLike(userLikeRepository.findByUserId(id));
		return user;
	}
	
	@PostMapping(path = "/user")
	public User saveUsers(@RequestBody User user) {
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()).toString());
		user.setJoinDate(new Date());
		user.setNowUse(true);
		return userRepository.save(user);
	}
	
//	@GetMapping(path = "/projects")
//	public List<Project> getProjects(){
//		return projectRepository.findAll();
//	}
	
	@PostMapping(path = "/project")
	public Project saveProject(@RequestBody Project project) {
		project.setNowUse(true);
		return projectRepository.save(project);
	}
	
	@PostMapping(path = "/like/{uId}/{pId}")
	public UserLike save(@PathVariable("uId") int uId, @PathVariable("pId") int pId) {
		UserLike userLike = new UserLike(uId, pId);
		return userLikeRepository.save(userLike);
		//return userLike;
	}
	
	
//	@Autowired
//	private CategoryFirstRepository categoryFirstRepository;
//	@GetMapping(path = "/category/first")
//	public List<CategoryFirst> getUsers(){
//		return categoryFirstRepository.findAll();
//	}
}