package com.example.snomate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sm_project_question")
public class ProjectQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "project_id")
	private int proejctId;
	
	@Column(name = "project_num")
	private int proejctNum;
	
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name = "qeustion")
	private String qeustion;
	
	@Column(name = "answer")
	private String answer;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "qeustion_date")
	private Date qeustionDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "answer_date")
	private Date answerDate;
}
