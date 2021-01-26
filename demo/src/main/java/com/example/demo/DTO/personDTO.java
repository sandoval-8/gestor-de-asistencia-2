package com.example.demo.DTO;

import com.example.demo.model.centro;
import com.example.demo.model.person;

import lombok.Data;

@Data
public class personDTO {
	
	public Long id;	
	public String nombre;
	public String apellido;
	public String funcion;
	public centro centroSalud;
	public String oficina;
	public String horario;
	public String legajo;
	
	public String fechaIncial;
	public String fechaFinal;
	
	public personDTO() {
		
	}
	//CENTRO-SALUD SIN FECHAS
	public personDTO(String nombre, String apellido, String funcion, centro centroSalud, String oficina, String horario,
			String legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.funcion = funcion;
		this.centroSalud = centroSalud;
		this.oficina = oficina;
		this.horario = horario;
		this.legajo = legajo;
	}
	
	//SIN FECHAS Y CENTRO-SALUD
	public personDTO(String nombre, String apellido, String funcion, String oficina, String horario, String legajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.funcion = funcion;
		this.oficina = oficina;
		this.horario = horario;
		this.legajo = legajo;
	}
	
	//FECHAS + CENTRO-SALUD
	public personDTO(String nombre, String apellido, String funcion, centro centroSalud, String oficina, String horario,
			String legajo, String fechaIncial, String fechaFinal) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.funcion = funcion;
		this.centroSalud = centroSalud;
		this.oficina = oficina;
		this.horario = horario;
		this.legajo = legajo;
		this.fechaIncial = fechaIncial;
		this.fechaFinal = fechaFinal;
	}
	
	
	
	
	
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
