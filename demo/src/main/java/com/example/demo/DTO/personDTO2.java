package com.example.demo.DTO;

import com.example.demo.model.person;

import lombok.Data;

@Data
public class personDTO2 {
	
	public Long id;	
	public String nombre;
	public String apellido;
	public String funcion;
	public String domicilio;
	public String oficina;
	public String horario;
	public String legajo;
	
	public personDTO2(person persona) {
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.funcion = persona.getFuncion();
		this.domicilio = persona.getDomicilio();
		this.oficina = persona.getOficina();
		this.horario = persona.getHorario();
		this.legajo = persona.getLegajo();
	}
}
