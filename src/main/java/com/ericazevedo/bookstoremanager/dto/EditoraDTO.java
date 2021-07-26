package com.ericazevedo.bookstoremanager.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Cria os GETTER e SETTERS
@Data

//Cria o objeto de forma diferente com menos linhas.
//EditoraDTO.builder().id(1L).nome("Teste").build();
@Builder

//Cria um contrutor sem argumentos
@NoArgsConstructor

//Cria um contrutor com todos os argumentos
@AllArgsConstructor
public class EditoraDTO {

	private Long id;
	
	//Trata os dados antes de irem pro banco de dados, para darem um retorno de erro melhor para o usuário.
	@NotBlank(message = "Nome precisa ser preenchido.")
	@Size(max = 50, message = "Máximo de 50 caracteres.")
	private String nome;
	
}
