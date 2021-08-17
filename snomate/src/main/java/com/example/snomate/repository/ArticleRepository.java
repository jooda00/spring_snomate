package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	Article findById(int i);

	Article findByUserId(int uId);
}
