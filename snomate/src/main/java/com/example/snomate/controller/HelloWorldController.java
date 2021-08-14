package com.example.snomate.controller;

import com.example.snomate.model.Project;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.repository.ProjectRepository;
import com.example.snomate.repository.TestRepository;
import com.example.snomate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

	
	// User
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	@PostMapping(path = "/users")
	public User saveUsers(@RequestBody User user) {
		return userRepository.save(user);
	}
	
//	@PutMapping(path = "/users/{id}")
//	public Integer updateUser(@PathVariable int id, @RequestBody User user) {
//		return userRepository.update(user.setTest();, id);
//	}
	

	// Project
	@GetMapping(path = "/projects")
	public List<Project> getProjects(){
		return projectRepository.findAll();
	}
	
	// project id를 통해 받아오기
	@GetMapping(path = "/projects/{pj_id}")
	public Optional<Project> retrieveProject(@PathVariable int pj_id) {
		return projectRepository.findById(pj_id);
	}
	
	// project delete
	/* @DeleteMapping(path = "/projects/{pj_id}")
	public Integer deleteProjectFromId(@PathVariable int pj_id) {
		projectRepository.deleteById(pj_id);
		return pj_id;
	} */
	
	// project insert
	@PostMapping(path = "/projects")
	public Project saveProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	// project update -> 아직 수정 해야 할 것!
    /* @PutMapping("/projects/{pj_id}")
    public ResponseEntity<Project> updateProject(@PathVariable int pj_id, @RequestBody Project project) {
    	Project p1 = projectRepository.findById(pj_id).orElseThrow(
                () -> new NullPointerException("해당 프로젝트의 아이디가 존재하지 않습니다.")
        );
    	p1.setTitle(project.getTitle());
    	p1.setPeriod(project.getPeriod());
    	p1.setBody_text(project.getBody_text());
    	p1.setBody_images(project.getBody_images());
    	p1.setUrl_link(project.getUrl_link());
    	p1.setIs_deleted(project.getIs_deleted());
    	p1.setQuestion1(project.getQuestion1());
    	p1.setAnswer1(project.getAnswer1());
    	p1.setQuestion2(project.getQuestion2());
    	p1.setAnswer2(project.getAnswer2());
    	p1.setQuestion3(project.getQuestion3());
    	p1.setAnswer3(project.getAnswer3());
    	final Project updatedProject = projectRepository.save(p1);
    	return ResponseEntity.ok(updatedProject); 
    } */

    
}