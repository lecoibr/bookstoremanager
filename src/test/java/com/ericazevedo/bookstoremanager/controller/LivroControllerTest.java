package com.ericazevedo.bookstoremanager.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.ericazevedo.bookstoremanager.dto.AutorDTO;
import com.ericazevedo.bookstoremanager.dto.EditoraDTO;
import com.ericazevedo.bookstoremanager.dto.LivroDTO;
import com.ericazevedo.bookstoremanager.dto.MessageResponseDTO;
import com.ericazevedo.bookstoremanager.service.LivroService;
import com.ericazevedo.bookstoremanager.util.Transforme;

@ExtendWith(MockitoExtension.class)
public class LivroControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private LivroService livroService; 
	
	@InjectMocks
	private LivroController livroController;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(livroController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
				.build();
	}
	
	@Test
	void testeDeCadastroDeLivroSucesso() throws Exception {
		LivroDTO livroLocal = LivroDTO.builder()
				.id(1L)
				.isbn("ISBN AQUI")
				.nome("Nome do Livro Aqui")
				.paginas(123)
				.capitulos(43)
				.editoraDTO(EditoraDTO.builder().id(1L).nome("Nome Editora Aqui").build())
				.autorDTO(AutorDTO.builder().id(1L).nome("Jose Nonato").idade(67).build())
				.build();
		
		MessageResponseDTO mensagemEsperada = MessageResponseDTO.builder()
				.mensagem("Livro criado com o ID -> " + livroLocal.getId())
				.build();
		
		//Quando chamar o livroService.create(livroLocal), retorne a "mensagemEsperada" 
		Mockito.when(livroService.create(livroLocal)).thenReturn(mensagemEsperada);
				
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Transforme.objectToJSON(livroLocal)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.mensagem", Is.is(mensagemEsperada.getMensagem())));
	}
	
	@Test
	void testeDeCadastroDeLivroErro() throws Exception {
		LivroDTO livroLocal = LivroDTO.builder()
				.id(1L)
				.isbn("ISBN AQUI")
				.nome("Nome do Livro Aqui Aqui Aqui  Aqui  Aqui  Aqui  Aqui") //Nome com mais de 50 caracteres irá gerar erro 400 (Bad Request).
				.paginas(123)
				.capitulos(43)
				.editoraDTO(EditoraDTO.builder().id(1L).nome("Nome Editora Aqui").build())
				.autorDTO(AutorDTO.builder().id(1L).nome("Jose Nonato").idade(67).build())
				.build();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Transforme.objectToJSON(livroLocal)))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}	
	
	
}
