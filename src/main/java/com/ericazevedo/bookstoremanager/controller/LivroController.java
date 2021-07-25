package com.ericazevedo.bookstoremanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericazevedo.bookstoremanager.dto.MessageResponseDTO;
import com.ericazevedo.bookstoremanager.entity.Livro;
import com.ericazevedo.bookstoremanager.service.LivroService;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	/**
	 * Exemplo do REST passado no Postman (http://localhost:8080/api/v1/livros)
	 * 
		{
		    "nome": "Investigador da Hora",
		    "paginas": 342,
		    "capitulos": 43,
		    "isbn": "ISBN - 123.655.13",
		    "autor": {
		        "nome": "Benjamim Branquilin",
		        "idade": 43
		    },
		    "editora" : {
		        "nome" : "Editora Moderna LTDA"
		    }
		
		}	 
	 
	 */
	@PostMapping
	public MessageResponseDTO create(@RequestBody Livro livro) {
		return livroService.create(livro);
	}

}
