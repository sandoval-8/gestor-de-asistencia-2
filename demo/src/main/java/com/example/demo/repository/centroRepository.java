package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.centro;
import com.example.demo.model.person;

@Repository
public interface centroRepository extends JpaRepository<centro, Long> {
//	public List<person> findByCentro_id(Long centro_id);
}
