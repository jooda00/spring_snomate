package com.example.snomate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sm_article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "title")
	private String title;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "start_date")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "update_date")
	private Date updateDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "end_date")
	private Date endDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "project_start_date")
	private Date projectStratDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "project_end_date")
	private Date projectEndDate;
	
	@Column(name = "body")
	private String body;
	
	@Column(name = "url_link")
	private String urlLink;
	
	@Column(name = "body_images")
	private String bodyImages;
	
	@Column(name = "now_use")
	private boolean nowUse;
	
	@Transient
	private List<ArticleQuestion> articleQuestions = null;
}
