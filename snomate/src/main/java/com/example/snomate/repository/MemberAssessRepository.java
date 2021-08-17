package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.MemberAssess;

@Repository
public interface MemberAssessRepository extends JpaRepository<MemberAssess, Integer> {

}
