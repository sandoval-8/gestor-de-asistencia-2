package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.personDTO;
import com.example.demo.mappings.PersonToPersonDTOMapper;
import com.example.demo.model.person;
import com.example.demo.repository.personRepository;

@Service
public class personService{
	
	@Autowired
	private personRepository repositorio;
	
	@Autowired
	private PersonToPersonDTOMapper mapeo;
	
	public List<personDTO> personAll(){
		List<personDTO> personasDTO = new ArrayList<personDTO>();		
		for(person persona : repositorio.findAll()) {
			personDTO personaDTO = mapeo.personToPersonDTO(persona);
			personasDTO.add(personaDTO);
		}
		return personasDTO;
	}
}
