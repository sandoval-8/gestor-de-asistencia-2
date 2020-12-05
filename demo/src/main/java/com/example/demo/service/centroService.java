package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.centro;
import com.example.demo.repository.centroRepository;

@Service
public class centroService {
	
	@Autowired
	private centroRepository centroRepositorio;
	
	//CONSULTAR TODOS LOS CENTROS
	public List<centro> getCentros(){		
		return new ArrayList<centro>(centroRepositorio.findAll());
	}
}
