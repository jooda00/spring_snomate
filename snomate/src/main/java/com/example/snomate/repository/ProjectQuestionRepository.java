package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.ProjectQuestion;

@Repository
public interface ProjectQuestionRepository extends JpaRepository<ProjectQuestion, Integer> {
	ProjectQuestion findById(int i);

	List<ProjectQuestion> findByProjectId(int projectId);

	@Query(value = "select * from sm_project_question where project_id = :pId and id > :qId and question_id = 0 order by question_date asc limit 1" , nativeQuery = true)
	List<ProjectQuestion> findByProjectId1(int pId, int qId);

	@Query(value = "select * from sm_project_question where project_id = :pId and question_id = :qId order by question_date asc" , nativeQuery = true)
	List<ProjectQuestion> findByProjectId2(int pId, int qId);
}
