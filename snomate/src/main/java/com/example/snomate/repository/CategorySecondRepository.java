package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.CategorySecond;

@Repository
public interface CategorySecondRepository extends JpaRepository<CategorySecond, Integer>{

	@Query(value = "select * from sm_category_second where first_Id = :firstId", nativeQuery = true)
	List<CategorySecond> findByCategorySeconds(int firstId);
}
