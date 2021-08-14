package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	Project findById(int i);
}
