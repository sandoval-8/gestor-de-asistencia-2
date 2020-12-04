package com.example.demo.convert;

import com.example.demo.DTO.centroDTO;
import com.example.demo.model.centro;

public class convertCentro {
	
	public convertCentro() {
		
	}
	
	public centro getCentro(centroDTO CentroDTO) {
		centro Centro = new centro();
		
		Centro.setId(CentroDTO.getId());
		Centro.setDomicilio(CentroDTO.getDomicilio());
		
		return Centro;
	}
	
	public centroDTO getCentroDTO(centro Centro) {
		centroDTO CentroDTO = new centroDTO();
		
		CentroDTO.setId(Centro.getId());
		CentroDTO.setDomicilio(Centro.getDomicilio());
		
		return CentroDTO;
	}
}
