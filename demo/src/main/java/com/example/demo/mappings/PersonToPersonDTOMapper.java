package com.example.demo.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.DTO.personDTO;
import com.example.demo.model.person;

@Mapper(componentModel = "spring")
public interface PersonToPersonDTOMapper {
	PersonToPersonDTOMapper INSTANCE = Mappers.getMapper(PersonToPersonDTOMapper.class);
	
	personDTO personToPersonDTO(person persona);
	person personDTOToPerson(personDTO personaDTO);
}
