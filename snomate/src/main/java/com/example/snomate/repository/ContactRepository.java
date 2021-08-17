package com.example.snomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
