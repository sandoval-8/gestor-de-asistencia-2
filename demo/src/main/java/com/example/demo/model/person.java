package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String funcion;	
//	private centro domicilio;
	
	@ManyToOne
//	@JoinColumn(name="centro_id")
	private centro centroSalud;
	private String oficina;
	private String horario;
	private String legajo;
	
	public person (){
		
	}

}
