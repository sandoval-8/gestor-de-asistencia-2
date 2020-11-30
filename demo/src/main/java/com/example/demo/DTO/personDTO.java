package com.example.demo.DTO;

import com.example.demo.model.person;

import lombok.Data;

@Data
public class personDTO {
	
	public Long id;	
	public String nombre;
	public String apellido;
	public String funcion;
	public String domicilio;
	public String oficina;
	public String horario;
	public String legajo;
	
/*	public personDTO(person persona) {
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.funcion = persona.getFuncion();
		this.domicilio = persona.getDomicilio();
		this.oficina = persona.getHorario();
		this.horario = persona.getHorario();
		this.legajo = persona.getLegajo();
	}	*/

}
