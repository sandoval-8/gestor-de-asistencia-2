package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.centro;
import com.example.demo.model.person;

@EnableJpaRepositories
public interface personRepository extends JpaRepository<person, Long>{
	
	public List<person> findByCentroSalud(centro Centro);
	
	public Optional<person> findById(Long id);
	
	public Optional<person> findByLegajo(String legajo);
	
}
