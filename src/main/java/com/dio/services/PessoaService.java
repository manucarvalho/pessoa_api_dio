package com.dio.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.dto.request.PessoaDTO;
import com.dio.dto.response.MensagemRespostaDTO;
import com.dio.entities.Pessoa;
import com.dio.exceptions.PessoaNotFoundException;
import com.dio.mapper.PessoaMapper;
import com.dio.repositories.PessoaRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
	
	private PessoaRepository repository;

	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE; 	
	
	public MensagemRespostaDTO criarPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);
		Pessoa pessoaSalva = repository.save(pessoaParaSalvar);
		return criarMessagemResposta(pessoaSalva.getId(), "Pessoa criada com id ");
	}


	public List<PessoaDTO> listaTodos() {
		List<Pessoa> todasPessoas = repository.findAll();
		return todasPessoas.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());
		
	}


	public PessoaDTO buscarPorId(Long id) throws PessoaNotFoundException {
		Pessoa pessoa = verificarSeExiste(id);
		return pessoaMapper.toDTO(pessoa);
	}


	public void deletar(Long id) throws PessoaNotFoundException {
		verificarSeExiste(id);
		repository.deleteById(id);
	}

	public MensagemRespostaDTO atualizarPorId(Long id, @Valid PessoaDTO pessoaDTO) throws PessoaNotFoundException {
		verificarSeExiste(id);
		Pessoa pessoaParaAtualizar = pessoaMapper.toModel(pessoaDTO);
		Pessoa pessoaAtualizada = repository.save(pessoaParaAtualizar);
		return criarMessagemResposta(pessoaAtualizada.getId(), "Pessoa atualizada com id ");
	}
	
	private Pessoa verificarSeExiste(Long id) throws PessoaNotFoundException {
		return repository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
	}
	
	private MensagemRespostaDTO criarMessagemResposta(Long id, String msg) {
		return MensagemRespostaDTO.builder().mensagem(msg + id).build();
	}
}
