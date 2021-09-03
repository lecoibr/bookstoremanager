package com.ericazevedo.bookstoremanager.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ericazevedo.bookstoremanager.dto.LivroDTO;
import com.ericazevedo.bookstoremanager.dto.MessageResponseDTO;
import com.ericazevedo.bookstoremanager.exception.LivroNaoEncontradorException;
import com.ericazevedo.bookstoremanager.service.LivroService;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	/**
	 * Exemplo do REST passado no Postman:
	 * 		  LOCAL: http://localhost:8080/api/v1/livros
	 * 		HEROKU : https://bookstoremanager-udemy-course.herokuapp.com/api/v1/livros
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
	public MessageResponseDTO create(@RequestBody @Valid LivroDTO livroDTO) {
		return livroService.create(livroDTO);
	}
	
	@GetMapping("/{id}")
	public LivroDTO findById(@PathVariable Long id) throws LivroNaoEncontradorException {
		return livroService.findById(id);
	}

}
