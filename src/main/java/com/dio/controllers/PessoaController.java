package com.dio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.dto.request.PessoaDTO;
import com.dio.dto.response.MensagemRespostaDTO;
import com.dio.exceptions.PessoaNotFoundException;
import com.dio.services.PessoaService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {
	
	private PessoaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemRespostaDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
		return service.criarPessoa(pessoaDTO);
	}
	
	@GetMapping
	public List<PessoaDTO> listarTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("/{id}")
	public PessoaDTO buscarPorId(@PathVariable Long id) throws PessoaNotFoundException {
		return service.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Long id) throws PessoaNotFoundException {
		service.deletar(id);
	}
	
	@PutMapping("/{id}")
	public MensagemRespostaDTO atualizarPorId(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNotFoundException {
		return service.atualizarPorId(id, pessoaDTO);
	}
}
