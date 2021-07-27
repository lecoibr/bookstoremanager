package com.ericazevedo.bookstoremanager.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ericazevedo.bookstoremanager.dto.LivroDTO;
import com.ericazevedo.bookstoremanager.entity.Autor;
import com.ericazevedo.bookstoremanager.entity.Editora;
import com.ericazevedo.bookstoremanager.entity.Livro;
import com.ericazevedo.bookstoremanager.exception.LivroNaoEncontradorException;
import com.ericazevedo.bookstoremanager.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {
	
	@Mock
	private LivroRepository livroRepository;
	
	
	@InjectMocks
	private LivroService livroService; 
	
	
	@Test
	void testePesquisaoDeLivroSucesso() throws LivroNaoEncontradorException {
		Livro livroLocal = Livro.builder()
				.id(1L)
				.isbn("ISBN AQUI")
				.nome("Nome do Livro Aqui")
				.paginas(123)
				.capitulos(43)
				.editora(Editora.builder().id(1L).nome("Nome Editora Aqui").build())
				.autor(Autor.builder().id(1L).nome("Jose Nonato").idade(67).build())
				.build();
		
		Mockito.when(livroRepository.findById(livroLocal.getId()))
		.thenReturn(Optional.of(livroLocal));
		
		LivroDTO livroDTO = livroService.findById(livroLocal.getId());
		
		Assertions.assertEquals(livroLocal.getNome(), livroDTO.getNome());
	}
	
	@Test
	void testePesquisaoDeLivroErro() throws LivroNaoEncontradorException {
		Long idInvalido = 10L;
		
		Mockito.when(livroRepository.findById(idInvalido))
		.thenReturn(Optional.ofNullable(Mockito.any(Livro.class)));
		
		Assertions.assertThrows(LivroNaoEncontradorException.class, () -> livroService.findById(idInvalido));
	}

}