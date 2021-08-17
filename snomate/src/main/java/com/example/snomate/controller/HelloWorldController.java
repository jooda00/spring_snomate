package com.example.snomate.controller;

import com.example.snomate.model.CategoryFirst;
import com.example.snomate.model.CategorySecond;
import com.example.snomate.model.Article;
import com.example.snomate.model.ArticleQuestion;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.model.UserLike;
import com.example.snomate.repository.CategoryFirstRepository;
import com.example.snomate.repository.CategorySecondRepository;
import com.example.snomate.repository.ArticleQuestionRepository;
import com.example.snomate.repository.ArticleRepository;
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
import java.util.Optional;

@RestController
public class HelloWorldController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticleQuestionRepository articleQuestionRepository;
	@Autowired
	private UserLikeRepository userLikeRepository;
	@Autowired
	private CategoryFirstRepository categoryFirstRepository;
	@Autowired
	private CategorySecondRepository categorySecondRepository;

	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
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
	
	@GetMapping(path = "/article/{id}")
	public Article getProject(@PathVariable("id") int pId){
		Article project = articleRepository.findById(pId);
		List<ArticleQuestion> returnQuestion = new ArrayList<ArticleQuestion>();
		List<ArticleQuestion> projectQuestion = articleQuestionRepository.findByArticleId1(pId, 0);
		
		while(!projectQuestion.isEmpty()) {
			returnQuestion.addAll(projectQuestion);
			int qId = projectQuestion.get(0).getId();
			returnQuestion.addAll(articleQuestionRepository.findByArticleId2(pId, qId));
			projectQuestion = articleQuestionRepository.findByArticleId1(pId, qId);
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
		project.setArticleQuestions(returnQuestion);
		return project;
	}
	
	
	@PostMapping(path = "/article")
	public Article saveProject(@RequestBody Article project) {
		project.setStratDate(new Date());
		project.setNowUse(true);
		return articleRepository.save(project);
	}
	
	@PostMapping(path = "/question")
	public ArticleQuestion saveQuestion(@RequestBody ArticleQuestion question) {
		question.setQuestionDate(new Date());
		return articleQuestionRepository.save(question);
	}
	
	@PostMapping(path = "/like/{uId}/{pId}")
	public UserLike save(@PathVariable("uId") int uId, @PathVariable("pId") int pId) {
		UserLike userLike = new UserLike(uId, pId);
		return userLikeRepository.save(userLike);
		//return userLike;
	}
	
	// Category1
	@GetMapping(path = "/category/{id}")
	public CategoryFirst getCategoryFirst(@PathVariable("id") int id){
		CategoryFirst categoryFirst = categoryFirstRepository.findById(id);
		List<CategorySecond> returnCategory = categorySecondRepository.findByCategorySeconds(id);
		categoryFirst.setCategorySecond(returnCategory);
		return categoryFirst;
	}
	
	
	
	// CategorySecond
	@GetMapping(path = "/category")
	public List<CategorySecond> getCategorySecond(){
		return categorySecondRepository.findAll();
	}
	
	@PostMapping(path = "/category")
	public CategorySecond saveCategorySecond(@RequestBody CategorySecond categorySecond) {
		return categorySecondRepository.save(categorySecond);
	}
	
//	@GetMapping(path = "/category/{firstId}")
//	public List<CategorySecond> getCategorySecondByID(@PathVariable int firstId) {
//		List<CategorySecond> returnList = categorySecondRepository.findByCategorySeconds(firstId);
//		return returnList;
//	}

}