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
@Table(name = "sm_member_assess")
public class MemberAssess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "article_id")
	private int articleId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "member_id")
	private int memberId;
	
	@Column(name = "assess_hardworking")
	private float assessHardworking;
	
	@Column(name = "assess_ability")
	private float assessAbility;
	
	@Column(name = "assess_leadership")
	private float assessLeadership;
	
	@Column(name = "assess_communication")
	private float assessCommunication;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "assess_date")
	private Date assessDate;
	
	//assesscheck
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "update_date")
	private Date updateDate;
}
