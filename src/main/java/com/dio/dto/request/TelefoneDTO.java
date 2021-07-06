package com.dio.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.pessoaapi.enums.TelefoneTipo;

@Data
@Builder
public class TelefoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TelefoneTipo telefone;
	
	@NotEmpty
	@Size(min = 13, max= 14)
	private String numero;

}
