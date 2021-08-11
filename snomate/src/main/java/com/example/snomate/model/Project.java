package com.example.snomate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "snomate_project")
public class Project {

	@Id
	@GeneratedValue
	private Integer pj_id;
	
	@Column(name = "title")
	private String title;
	
	@Temporal(TemporalType.DATE) // 일단 날짜만 받아오기
	@Column(name = "period")
	private Date period;
	
	@Column(name = "body_text")
	private String body_text;
	
	@Column(name = "body_images")
	private String body_images;
	
	@Column(name = "url_link")
	private String url_link;
	
	@Column(name = "is_deleted")
	private Integer is_deleted;
	
	@Column(name = "question1")
	private String question1;
	
	@Column(name = "answer1")
	private String answer1;
	
	@Column(name = "question2")
	private String question2;
	
	@Column(name = "answer2")
	private String answer2;
	
	@Column(name = "question3")
	private String question3;
	
	@Column(name = "answer3")
	private String answer3;
	
}
