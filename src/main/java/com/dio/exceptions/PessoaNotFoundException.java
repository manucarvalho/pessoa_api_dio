package com.dio.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends Exception {
		
	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(Long id) {
		super("Pessoa não encontrada com o id "+id);
	}
}
