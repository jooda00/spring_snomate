package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.CategoryFirst;

@Repository
public interface CategoryFirstRepository extends JpaRepository<CategoryFirst, Integer>{

}