package com.example.demo.security.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.models.usuario;
import com.example.demo.security.repository.usuarioRepositorio;

@Service
public class usuarioDetallado implements UserDetailsService {
	
	private static Logger log = LoggerFactory.getLogger(usuarioDetallado.class);
	
	@Autowired
	private usuarioRepositorio repositorio; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<usuario> usuario = repositorio.findByUsername(username);
		if(usuario.isPresent()) {
			log.info("EL USUARIO SE RECUPERO CON EXITO (gener. UserDetails)");
			User userLoger = new User(usuario.get().getUsername(), usuario.get().getPassword(), null);
			return userLoger;
		}
		return new User(null, null, null);
	}

}
