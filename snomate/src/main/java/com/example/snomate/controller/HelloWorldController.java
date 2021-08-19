package com.example.snomate.controller;

import com.example.snomate.model.CategoryFirst;
import com.example.snomate.model.CategorySecond;
import com.example.snomate.model.Contact;
import com.example.snomate.model.MemberAssess;
import com.example.snomate.model.ArticlePreview;
import com.example.snomate.model.Alarm;
import com.example.snomate.model.Article;
import com.example.snomate.model.ArticleQuestion;
import com.example.snomate.model.Test;
import com.example.snomate.model.User;
import com.example.snomate.model.UserLike;
import com.example.snomate.repository.CategoryFirstRepository;
import com.example.snomate.repository.CategorySecondRepository;
import com.example.snomate.repository.ContactRepository;
import com.example.snomate.repository.MemberAssessRepository;
import com.example.snomate.repository.AlarmRepository;
import com.example.snomate.repository.ArticlePreviewRepository;
import com.example.snomate.repository.ArticleQuestionRepository;
import com.example.snomate.repository.ArticleRepository;
import com.example.snomate.repository.TestRepository;
import com.example.snomate.repository.UserLikeRepository;
import com.example.snomate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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
	@Autowired
	private ArticlePreviewRepository articlePreviewRepository;
	@Autowired
	private MemberAssessRepository memberAssessRepository;
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private AlarmRepository alramRepository;
	
	// article crud
	
	// 특정 게시물
	
	@GetMapping(path = "/article/{id}")
	public Article selectArticle(@PathVariable("id") int aId){
		Article article = articleRepository.findById(aId);
		List<ArticleQuestion> returnQuestion = new ArrayList<ArticleQuestion>();
		List<ArticleQuestion> projectQuestion = articleQuestionRepository.findByArticleId1(aId, 0);
		
		while(!projectQuestion.isEmpty()) {
			returnQuestion.addAll(projectQuestion);
			int qId = projectQuestion.get(0).getId();
			returnQuestion.addAll(articleQuestionRepository.findByArticleId2(aId, qId));
			projectQuestion = articleQuestionRepository.findByArticleId1(aId, qId);
		}
		
		article.setArticleQuestions(returnQuestion);
		return article;
	}
	
	// 최신글
	@GetMapping(path = "/article")
	public List<ArticlePreview> selectAllArticle(){
		return articlePreviewRepository.findTop10ByOrderByUpdateDateDesc();
	}
	
	// 카테고리별 최신글
	@GetMapping(path = "/article/category/{id}")
	public List<ArticlePreview> selectCategoryArticle(@PathVariable("id") int cId){
		return articlePreviewRepository.findByCategoryIdOrderByUpdateDateDesc(cId);
	}
	
	// 내가 쓴 글 (article과 같은 메뉴)
	@GetMapping(path = "/article/user/{id}")
	public List<ArticlePreview> selectUserArticle(@PathVariable("id") int uId){
		return articlePreviewRepository.findByUserIdOrderByUpdateDateDesc(uId);
	}
	
	// 게시글 등록
	@PostMapping(path = "/article")
	public Article insertArticle(@RequestBody Article article) {
		article.setStartDate(new Date());
		article.setUpdateDate(new Date());
		article.setNowUse(true);
		return articleRepository.save(article);
	}
	
	// 게시글 수정
	@PutMapping
	(path = "/article")
	public Article updateArticle(@RequestBody Article article) {
		article.setUpdateDate(new Date());
		return articleRepository.save(article);
	}
	
//	@DeleteMapping(path = "/article/{id}")
//	public Article deleteArticle(@PathVariable("id") int aId) {
//		Article article = articleRepository.findById(aId);
//		article.setNowUse(false);
//		return articleRepository.save(article);
//	}
	
	@GetMapping(path = "/delete/article/{id}")
	public Article deleteArticle(@PathVariable("id") int aId) {
		Article article = articleRepository.findById(aId);
		article.setNowUse(false);
		return articleRepository.save(article);
	}
	
	@PostMapping(path = "/question")
	public ArticleQuestion insertQuestion(@RequestBody ArticleQuestion question) {
		question.setQuestionDate(new Date());
		return articleQuestionRepository.save(question);
	}
	
	@PutMapping(path = "/question")
	public ArticleQuestion updateQuestion(@RequestBody ArticleQuestion question) {
		question.setAnswerDate(new Date());
		return articleQuestionRepository.save(question);
	}
	
	
	// Contact
	
	// 멤버 컨택
	@PostMapping(path = "/contact")
	public Contact insertContact(@RequestBody Contact contact) {
		contact.setContact(false);
		contact.setDone(false);
		contact.setRequestDate(new Date());
		
		String str = contact.getTitle();
		if (str != null) {
			if (str.length() > 10) {
				str = str.substring(0,10) + "...";
			}
		}else {
			// 넣어야 하나?
		}
		alramRepository.save(new Alarm(contact.getUserResponseId(), "컨텍 요청", "\"" + str + "\"에 컨텍 요청이 들어왔어요!", "", new Date()));
		
		return contactRepository.save(contact);
	}
	
	// 컨텍 피드백
	@PutMapping(path = "/contact")
	public Contact updateContact(@RequestBody Contact contact) {
		contact.setResponseDate(new Date());
		contact.setDone(true);
		
		String str = contact.getTitle();
		if (str != null) {
			if (str.length() > 10) {
				str = str.substring(0,10) + "...";
			}
		}else {
			// 넣어야 하나?
		}
		alramRepository.save(new Alarm(contact.getUserRequestId(), "컨텍 답변", "\"" + str + "\"에 보낸 컨텍에 답변이 도착했어요!", "", new Date()));
		
		return contactRepository.save(contact);
	}
	
	// 나의 컨택 봄
	@GetMapping(path = "/contact/request/{id}")
	public List<Contact> selectRequestContact(@PathVariable("id") int urId){
		return contactRepository.findByUserRequestId(urId);
	}
	@GetMapping(path = "/contact/response/{id}")
	public List<Contact> selectResponseContact(@PathVariable("id") int usId){
		return contactRepository.findByUserResponseId(usId);
	}
	
	// Assess
	
	// 조원평가
	@PostMapping(path = "/assess")
	public MemberAssess insertMemberAssess(@RequestBody MemberAssess assess) {
		assess.setAssessDate(new Date());
		assess.setUpdateDate(new Date());
		User user = userRepository.findById(assess.getMemberId());
		user.setTemperature(user.getTemperature() + assess.getAssessAbility() + assess.getAssessCommunication() + assess.getAssessHardworking() + assess.getAssessLeadership());
		userRepository.save(user);
		return memberAssessRepository.save(assess);
	}
	
	// 나의 평가(온도)보기
	@GetMapping(path = "/assess/{id}")
	public Float selectTemp(@PathVariable("id") int id) {
		User user = userRepository.findById(id);
		Float temperature = user.getTemperature();
		return temperature;
	}
	
	// user menu

	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable("id") int id){
		User user = userRepository.findById(id);
		user.setUserPassword(null);
		return user;
	}
	
	// 회원가입
	@PostMapping(path = "/user")
	public int insertUsers(@RequestBody User user) {
		User tmp = userRepository.findByUserEmail(user.getUserEmail());
		if(tmp == null) {
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()).toString());
			user.setJoinDate(new Date());
			user.setTemperature(36.5F);
			user.setNowUse(true);
			userRepository.save(user);
			return 0;
		}else {
			return 1;
		}
	}
	
	// 로그인
	@PostMapping(path = "/login")
	public int insertUsers(@RequestBody Map<String, String> tmp) {
		User user = userRepository.findByUserEmail(tmp.get("userEmail"));
		
		if (user == null) {
			return 2;
		}else {
		
			if(passwordEncoder.matches(tmp.get("userPassword"), user.getUserPassword())) {
				user.setLastLoginDate(new Date());
				userRepository.save(user);
				return 0;
			}else {
				return 1;
			}
		}
	}
	
	// 비밀번호 수정
	@PostMapping(path = "/password/{id}")
	public String updatePassword(@PathVariable("id") int uId, @RequestBody Map<String, String> password) {
		User user = userRepository.findById(uId);
		
		if(passwordEncoder.matches(password.get("original"), user.getUserPassword())) {
			if(password.get("modify").equals(password.get("check"))) {
				user.setUserPassword(passwordEncoder.encode(password.get("modify")));
				userRepository.save(user);
				return "변경되었습니다.";
			}else {
				return "바꿀 비밀번호가 일치하지 않습니다.";
			}
		}else {
			return "현재 비밀번호가 일치하지 않습니다.";
		}
	}
	
	// 즐겨찾기
	@PostMapping(path = "/like/{uId}/{aId}")
	public UserLike insertLike(@PathVariable("uId") int uId, @PathVariable("aId") int aId) {
		UserLike userLike = new UserLike(uId, aId);
		return userLikeRepository.save(userLike);
		//return userLike;
	}
	
	//즐겨찾기 리스트
	@GetMapping(path = "/like/{uId}")
	public List<UserLike> selectLike(@PathVariable("uId") int uId) {
		return userLikeRepository.findByUserId(uId);
	}
	
	// Category(얘는 나중에)
	
	// 카테고리1(대주제)별로 딸린 카테고리2(소주제들)보기
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
	
	// 카테고리2(소주제) 추가
//	@PostMapping(path = "/category")
//	public CategorySecond insertCategorySecond(@RequestBody CategorySecond categorySecond) {
//		return categorySecondRepository.save(categorySecond);
//	}
	
//	@GetMapping(path = "/category/{firstId}")
//	public List<CategorySecond> getCategorySecondByID(@PathVariable int firstId) {
//		List<CategorySecond> returnList = categorySecondRepository.findByCategorySeconds(firstId);
//		return returnList;
//	}

}