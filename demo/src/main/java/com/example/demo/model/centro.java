package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class centro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private String nombreCentro;
	
/*	@OneToMany
	@JoinColumn(name = "centro_id")
	private List<person> personal = new ArrayList<person>(); */
}
