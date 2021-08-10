package com.example.snomate.repository;

import com.example.snomate.model.HelloWorldBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloWorldBeanRepository extends JpaRepository<HelloWorldBean,Long> {
}
