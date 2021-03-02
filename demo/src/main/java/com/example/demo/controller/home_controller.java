package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.centroDTO;
import com.example.demo.DTO.personDTO;
import com.example.demo.service.centroService;
import com.example.demo.service.personService;

@Controller
public class home_controller {
	
	@Autowired
	private personService servicio;
	
	@Autowired
	private centroService servicioCentro;
	
	@GetMapping("/")
	public String index(Model modelo) {
		List<personDTO> personas = servicio.personAll();
		modelo.addAttribute("personas", personas);
		List<centroDTO> centros = servicioCentro.getCentros();
		modelo.addAttribute("centros", centros);
		return "listaTabla";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
