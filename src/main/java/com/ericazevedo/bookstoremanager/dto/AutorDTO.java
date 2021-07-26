package com.ericazevedo.bookstoremanager.dto;

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
//AutorDTO.builder().id(1L).idade(123).build();
@Builder

//Cria um contrutor sem argumentos
@NoArgsConstructor

//Cria um contrutor com todos os argumentos
@AllArgsConstructor
public class AutorDTO {
	
	private Long id;
	
	//Trata os dados antes de irem pro banco de dados, para darem um retorno de erro melhor para o usuário.
	@NotBlank(message = "Nome precisa ser preenchido.")
	@Size(max = 200, message = "Máximo de 200 caracteres.")
	private String nome;
	
	//Trata os dados antes de irem pro banco de dados, para darem um retorno de erro melhor para o usuário.
	@NotNull(message = "Idade não pode ser nulo.")
	@Size(max = 100, message = "Máximo de 100 anos de idade.")
	private Integer idade;

}

