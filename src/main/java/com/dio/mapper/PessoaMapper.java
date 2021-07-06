package com.dio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dio.dto.request.PessoaDTO;
import com.dio.entities.Pessoa;

@Mapper
public interface PessoaMapper {
	
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
	
	@Mapping(target = "dataNascimento", source="dataNascimento", dateFormat = "dd-MM-yyyy")
	Pessoa toModel(PessoaDTO pessoaDTO);
	
	PessoaDTO toDTO(Pessoa pessoa);
}
