package com.example.snomate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "snomate_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_email")
	private String user_email;
	
	@Column(name = "user_password")
	private String user_password;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "test")
	private String test;
	
	@Column(name = "temperature")
	private Float temperature;
}
