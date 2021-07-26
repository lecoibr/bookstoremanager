package com.ericazevedo.bookstoremanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ericazevedo.bookstoremanager.dto.LivroDTO;
import com.ericazevedo.bookstoremanager.entity.Livro;

//Faz a conversão de DTO para outro Objeto e vice e versa.
@Mapper
public interface LivroMapper {
	
	LivroMapper INSTANCIA = Mappers.getMapper(LivroMapper.class);

	Livro toModel(LivroDTO livroDTO);
	
	LivroDTO toDto(Livro livro);
	
}
