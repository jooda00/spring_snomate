package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.ArticlePreview;

@Repository
public interface ArticlePreviewRepository extends JpaRepository<ArticlePreview, Integer> {

	List<ArticlePreview> findByUserIdOrderByUpdateDateDesc(int uId);

	List<ArticlePreview> findByCategoryIdOrderByUpdateDateDesc(int cId);

	List<ArticlePreview> findTop10ByOrderByUpdateDateDesc();

}
