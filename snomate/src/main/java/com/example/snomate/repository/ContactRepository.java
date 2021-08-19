package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByUserRequestId(int urId);

	List<Contact> findByUserResponseId(int usId);

}
