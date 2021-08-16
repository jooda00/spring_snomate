package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.CategoryFirst;
import com.example.snomate.model.Project;

@Repository
public interface CategoryFirstRepository extends JpaRepository<CategoryFirst, Integer>{

	CategoryFirst findById(int i);
}