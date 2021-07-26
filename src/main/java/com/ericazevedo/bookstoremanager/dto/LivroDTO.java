package com.ericazevedo.bookstoremanager.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Cria os GETTER e SETTERS
@Data

//Cria o objeto de forma diferente com menos linhas.
//LivroDTO.builder().id(1L).isbn("local").nome("Nome").build();
@Builder

//Cria um contrutor sem argumentos
@NoArgsConstructor

//Cria um contrutor com todos os argumentos
@AllArgsConstructor
public class LivroDTO {
	
	private Long id;
	
	//Trata os dados antes de irem pro banco de dados, para darem um retorno de erro melhor para o usuário.
	@NotBlank(message = "Nome precisa ser preenchido.")
	@Size(max = 200, message = "Máximo de 200 caracteres.")
	private String nome;
	
	@NotNull(message = "Páginas não pode ser nulo.")
	private Integer paginas;
	
	@NotNull(message = "Capítulos não pode ser nulo.")
	private Integer capitulos;
	
	@NotBlank(message = "ISBN precisa ser preenchido.")
	@Size(max = 100, message = "Máximo de 200 caracteres.")
	private String isbn;
	
	@Valid
	@NotBlank(message = "EditoraDTO precisa ser preenchido.")
	private EditoraDTO editoraDTO;
	
	@Valid
	@NotBlank(message = "AutorDTO precisa ser preenchido.")
	private AutorDTO autorDTO;
	
}
