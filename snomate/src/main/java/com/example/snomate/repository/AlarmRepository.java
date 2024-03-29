package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.Alarm;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Integer> {

}
