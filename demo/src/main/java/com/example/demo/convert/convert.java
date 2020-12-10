package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.personDTO;
import com.example.demo.model.person;

@Component
public class convert {
	
	public convert() {
		
	}
	public person getPerson(personDTO personaDTO) {
		person persona = new person();
		
		persona.setId(personaDTO.getId());
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setFuncion(personaDTO.getFuncion());
		persona.setCentroSalud(personaDTO.getCentroSalud());
		persona.setOficina(personaDTO.getOficina());
		persona.setHorario(personaDTO.getHorario());
		persona.setLegajo(personaDTO.getLegajo());
		
		return persona;
	}
	
	public personDTO getPersonDTO(person persona) {
		personDTO personaDTO = new personDTO();
		
		personaDTO.setId(persona.getId());
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setApellido(persona.getApellido());
		personaDTO.setFuncion(persona.getFuncion());
		personaDTO.setCentroSalud(persona.getCentroSalud());
		personaDTO.setOficina(persona.getOficina());
		personaDTO.setHorario(persona.getHorario());
		personaDTO.setLegajo(persona.getLegajo());
		
		return personaDTO;
	}
}
