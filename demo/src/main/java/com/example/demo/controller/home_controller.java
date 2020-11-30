package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.person;
import com.example.demo.service.personService;

@Controller
public class home_controller {
	
	@Autowired
	private personService servicio;
	
	@GetMapping("/")
	public String index(Model modelo) {
		List<person> personas = servicio.personAll();
		modelo.addAttribute("personas", personas);
		return "listaTabla";
	}
}
