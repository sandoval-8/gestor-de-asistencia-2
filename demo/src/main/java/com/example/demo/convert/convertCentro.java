package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.centroDTO;
import com.example.demo.model.centro;

@Component
public class convertCentro {
	
	public convertCentro() {
		
	}
	
	public centro getCentro(centroDTO CentroDTO) {
		centro Centro = new centro();
		
		Centro.setId(CentroDTO.getId());
		Centro.setNombreCentro(CentroDTO.getNombreCentro());
		Centro.setPersonal(CentroDTO.getPersonal());
		
		return Centro;
	}
	
	public centroDTO getCentroDTO(centro Centro) {
		centroDTO CentroDTO = new centroDTO();
		
		CentroDTO.setId(Centro.getId());
		CentroDTO.setNombreCentro(Centro.getNombreCentro());
		CentroDTO.setPersonal(Centro.getPersonal());
		
		return CentroDTO;
	}
}
