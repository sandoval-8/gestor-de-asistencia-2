package com.example.demo.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.security.models.usuario;

public interface usuarioRepositorio extends JpaRepository<usuario, Long> {

	public Optional<usuario> findByUsername(String username);
}
