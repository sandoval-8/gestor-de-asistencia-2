package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.personDTO;
import com.example.demo.service.personService;

@Controller
@RequestMapping("/lista")
public class crud_controller {
	
	@Autowired
	public personService servicioPersona;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<personDTO>> getList(){
		return new ResponseEntity<List<personDTO>>(servicioPersona.personAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<personDTO> getPerson(@PathVariable Long id){
		return new ResponseEntity<personDTO>(servicioPersona.person(id), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<personDTO> createPerson(@RequestBody personDTO personaDTO){
		return new ResponseEntity<personDTO>(servicioPersona.createPerson(personaDTO), HttpStatus.OK);		
	}
	
	@PutMapping({"/{id}"})
	public ResponseEntity<personDTO> updatePerson(@PathVariable Long id, @RequestBody personDTO personaDTO){
		return new ResponseEntity<personDTO>(servicioPersona.personUpdate(personaDTO), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<List<personDTO>> deletePerson(@PathVariable Long id){
		boolean valor = servicioPersona.personDelete(id);
		if(valor) {
			return  new ResponseEntity<List<personDTO>>(servicioPersona.personAll(), HttpStatus.OK);
		}else {
			return new ResponseEntity<List<personDTO>>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
		}
	}
}
