package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.centroDTO;
import com.example.demo.convert.convertCentro;
import com.example.demo.model.centro;
import com.example.demo.repository.centroRepository;

@Service
public class centroService {
	
	@Autowired
	private centroRepository centroRepositorio;
	
	@Autowired
	private convertCentro convertidor;
	
	//CONSULTAR TODOS LOS CENTROS
	public List<centroDTO> getCentros(){	
		List<centroDTO> centrosDTO = new ArrayList<centroDTO>();
		for(centro Centro : centroRepositorio.findAll()) {
			centrosDTO.add(convertidor.getCentroDTO(Centro));
		}
		return centrosDTO;
	}
}
