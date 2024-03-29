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
@Table(name = "sm_contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "article_id")
	private int articleId;
	
	@Column(name = "user_request_id")
	private int userRequestId;
	
	@Column(name = "user_response_id")
	private int userResponseId;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "is_contact")
	private boolean isContact;
	
	@Column(name = "is_done")
	private boolean isDone;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "request_date")
	private Date requestDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "response_date")
	private Date responseDate;
	
	@Column(name = "reply")
	private String reply;
}
