package com.dio.dto.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;
import lombok.Data;

@Data
public class PessoaDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 2, max= 100)
	private String nome;
	
	@NotEmpty
	@Size(min = 2, max= 100)
	private String sobrenome;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	private LocalDate dataNascimento;
	
	@NotEmpty
	private List<TelefoneDTO> telefones = new ArrayList<>();
}
