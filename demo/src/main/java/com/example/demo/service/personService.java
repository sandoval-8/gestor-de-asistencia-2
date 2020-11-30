package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.person;
import com.example.demo.repository.personRepository;

@Service
public class personService{
	
	@Autowired
	private personRepository repositorio;
	
	public List<person> personAll(){
		List<person> personas = new ArrayList<person>();
		return personas = repositorio.findAll();
	}
}
