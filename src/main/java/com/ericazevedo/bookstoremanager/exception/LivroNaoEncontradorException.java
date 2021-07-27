package com.ericazevedo.bookstoremanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivroNaoEncontradorException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradorException (Long id) {
		super("Livro com ID " + id + " não existe !");
	}

}
