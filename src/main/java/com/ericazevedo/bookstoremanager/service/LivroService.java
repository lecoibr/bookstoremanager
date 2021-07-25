package com.ericazevedo.bookstoremanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericazevedo.bookstoremanager.dto.MessageResponseDTO;
import com.ericazevedo.bookstoremanager.entity.Livro;
import com.ericazevedo.bookstoremanager.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public MessageResponseDTO create(Livro livro) {
		Livro livroSalvo = livroRepository.save(livro);
		return MessageResponseDTO.builder()
				.mensagem("Livro criado com o ID: " + livroSalvo.getId())
				.build();
	}

}
