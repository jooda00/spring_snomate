package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.ArticleQuestion;

@Repository
public interface ArticleQuestionRepository extends JpaRepository<ArticleQuestion, Integer> {
	ArticleQuestion findById(int i);

	List<ArticleQuestion> findByArticleId(int articleId);

	@Query(value = "select * from sm_article_question where article_id = :aId and id > :qId and question_id = 0 order by question_date asc limit 1" , nativeQuery = true)
	List<ArticleQuestion> findByArticleId1(int aId, int qId);

	@Query(value = "select * from sm_article_question where article_id = :aId and question_id = :qId order by question_date asc" , nativeQuery = true)
	List<ArticleQuestion> findByArticleId2(int aId, int qId);

	@Query(value = "select title from sm_article where id = :aId" , nativeQuery = true)
	String findTitleById(int aId);
}
