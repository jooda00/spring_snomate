package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.ArticleMember;

@Repository
public interface ArticleMemberRepository extends JpaRepository<ArticleMember, Integer>{

}
