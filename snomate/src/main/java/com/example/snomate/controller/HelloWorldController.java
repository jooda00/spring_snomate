package com.example.snomate.controller;

import com.example.snomate.model.CategoryFirst;
import com.example.snomate.model.Project;
import com.example.snomate.model.ProjectQuestion;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.model.UserLike;
import com.example.snomate.repository.CategoryFirstRepository;
import com.example.snomate.repository.ProjectQuestionRepository;
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

import java.util.ArrayList;
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
	private ProjectQuestionRepository projectQuestionRepository;
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
		//user.setUserLike(userLikeRepository.findByUserId(id));
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
	
	@GetMapping(path = "/project/{id}")
	public Project getProject(@PathVariable("id") int pId){
		Project project = projectRepository.findById(pId);
		List<ProjectQuestion> returnQuestion = new ArrayList<ProjectQuestion>();
		List<ProjectQuestion> projectQuestion = projectQuestionRepository.findByProjectId1(pId, 0);
		
		while(!projectQuestion.isEmpty()) {
			returnQuestion.addAll(projectQuestion);
			int qId = projectQuestion.get(0).getId();
			returnQuestion.addAll(projectQuestionRepository.findByProjectId2(pId, qId));
			projectQuestion = projectQuestionRepository.findByProjectId1(pId, qId);
		}
		
		
		
		//List<ProjectQuestion> projectQuestion = projectQuestionRepository.findByProjectId(id);
//		List<ProjectQuestion> returnQuestion = new ArrayList<ProjectQuestion>();
//		
//		ProjectQuestion tmp1, tmp2;
//		for (int i = 0; i < projectQuestion.size(); i++) {
//			tmp1 = projectQuestion.get(i);
//			//tmp2 = projectQuestion.get(i + 1);
//			
//			if (tmp1.getQuestionId() == 0)
//				returnQuestion.add(tmp1);
//			else {
//				tmp2 = projectQuestion.get(i + 1);
//			}
//		}
//		
		project.setProjectQuestion(returnQuestion);
		return project;
	}
	
	@PostMapping(path = "/project")
	public Project saveProject(@RequestBody Project project) {
		project.setStratDate(new Date());
		project.setNowUse(true);
		return projectRepository.save(project);
	}
	
	@PostMapping(path = "/question")
	public ProjectQuestion saveQuestion(@RequestBody ProjectQuestion question) {
		question.setQuestionDate(new Date());
		return projectQuestionRepository.save(question);
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