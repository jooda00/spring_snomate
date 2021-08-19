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
@Table(name = "sm_article_member")
public class ArticleMember {
	
	public ArticleMember(int articleId, int userId, boolean isBoss) {
		this.articleId = articleId;
		this.userId = userId;
		this.isBoss = isBoss;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "article_id")
	private int articleId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "is_boss")
	private boolean isBoss;
}
