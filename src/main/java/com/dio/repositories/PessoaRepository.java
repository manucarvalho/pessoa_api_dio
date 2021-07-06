package com.dio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
