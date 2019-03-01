package com.vsm.devcase.repository;

import org.springframework.data.repository.CrudRepository;

import com.vsm.devcase.model.Pontuacao;


/**
 * Repositório padrão (CRUD) do cadastro da pontuação. 
 */
public interface PontuacaoRepository extends CrudRepository<Pontuacao, Long> {

}
