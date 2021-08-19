package com.example.snomate.model;

import java.util.Date;
import java.util.List;

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
@Table(name = "sm_alarm")
public class Alarm {
	
	public Alarm(int userId, String title, String body, String url, Date createDate) {
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.url = url;
		this.createDate = createDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body")
	private String body;
	
	@Column(name = "url")
	private String url;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_date")
	private Date createDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "check_date")
	private Date checkDate;
	
	@Column(name = "is_checked")
	private boolean isChecked;
}
