package com.ericazevedo.bookstoremanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Diz que essa classe é uma entidade no BD
@Entity

//Cria os GETTER e SETTERS
@Data

//Cria o objeto de forma diferente com menos linhas.
//Editora.builder().id(1L).nome("Teste").build();
@Builder

//Cria um contrutor sem argumentos
@NoArgsConstructor

//Cria um contrutor com todos os argumentos
@AllArgsConstructor
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false, unique = true)
	private String nome;
	
	private void teste() {
		Livro.builder().id(1L).isbn("local").nome("Nome").build();
		Autor.builder().id(1L).idade(123).build();
		
		Editora.builder().id(1L).nome("Teste").build();
	}
}
