package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.centroDTO;
import com.example.demo.DTO.personDTO;
import com.example.demo.convert.convert;
import com.example.demo.convert.convertCentro;
import com.example.demo.model.person;
import com.example.demo.repository.personRepository;

@Service
public class personService{
	
	@Autowired
	private personRepository repositorio;
	
	@Autowired
	private convert convertidor;
	
	@Autowired
	private convertCentro convertidorCentro;
	
	//CONSULTAR PERSONAS POR CENTRO
	public List<personDTO> personForCentro(centroDTO CentroDTO){
		
		List<personDTO> personasDTO = new ArrayList<personDTO>();		
		for(person persona : repositorio.findByCentroSalud(convertidorCentro.getCentro(CentroDTO))) {				
			personasDTO.add(convertidor.getPersonDTO(persona));
		}
		return personasDTO;
	}
	
	//CONSULTA TODAS LAS PERSONAS
	public List<personDTO> personAll(){
		List<personDTO> personasDTO = new ArrayList<personDTO>();		
		for(person persona : repositorio.findAll()) {		
			personasDTO.add(convertidor.getPersonDTO(persona));
		}
		return personasDTO;
	}
	
	//CONSULTA UNA SOLA PERSONA
	public personDTO person(Long id) {
		return convertidor.getPersonDTO(repositorio.findById(id).get());
	}
	
	//CREA UNA PERSONA
	public personDTO createPerson(personDTO personaDTO) {
		boolean persona = repositorio.findById(convertidor.getPerson(personaDTO).getId()).isPresent();
		if(persona == true) {
			System.out.println("El usuario ya existe");
			return convertidor.getPersonDTO((person)repositorio.findById(convertidor.getPerson(personaDTO).getId()).get());
		}else {
			return convertidor.getPersonDTO((person)repositorio.save(convertidor.getPerson(personaDTO)));
		}
	}
	
	//ACTUALIZA UNA PERSONA
	public personDTO personUpdate(personDTO personaDTO) {
		personDTO personaConsulta = convertidor.getPersonDTO((repositorio.findById(personaDTO.getId()).get()));
		if(personaConsulta != null) {
			return convertidor.getPersonDTO((person)repositorio.save(convertidor.getPerson(personaDTO)));
		}
		return null;
	} 
	
	//BORRA UNA PERSONA
	public boolean personDelete(Long id) {
		person persona = repositorio.findById(id).get();
		if(persona != null) {
			repositorio.delete(persona);
			return true;
		}
		return false;
		
	}
}
