package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.UserLike;

@Repository
public interface UserLikeRepository extends JpaRepository<UserLike, Integer>{

	List<UserLike> findByUserId(int id);

}
