package com.example.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.security.models.usuario;

public interface usuarioRepositorio extends JpaRepository<usuario, Long> {

}
