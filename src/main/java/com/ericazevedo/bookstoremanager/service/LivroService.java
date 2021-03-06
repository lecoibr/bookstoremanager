package com.ericazevedo.bookstoremanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericazevedo.bookstoremanager.dto.LivroDTO;
import com.ericazevedo.bookstoremanager.dto.MessageResponseDTO;
import com.ericazevedo.bookstoremanager.entity.Livro;
import com.ericazevedo.bookstoremanager.exception.LivroNaoEncontradorException;
import com.ericazevedo.bookstoremanager.mapper.LivroMapper;
import com.ericazevedo.bookstoremanager.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	private static final LivroMapper livroMapper = LivroMapper.INSTANCIA;
	
	public MessageResponseDTO create(LivroDTO livroDTO) {
		
		Livro novoLivro = livroMapper.toModel(livroDTO);
		
		Livro livroSalvo = livroRepository.save(novoLivro);
		
		return MessageResponseDTO.builder()
				.mensagem("Livro criado com o ID -> " + livroSalvo.getId())
				.build();
	}

	public LivroDTO findById(Long id) throws LivroNaoEncontradorException {
		Livro livro = livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradorException(id));
		return livroMapper.toDto(livro);
	}

}
