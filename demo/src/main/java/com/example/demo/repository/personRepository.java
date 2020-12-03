package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.person;


public interface personRepository extends JpaRepository<person, Long>{
	
	public List<person> findByPerson(person persona);
}
