package com.vsm.devcase.repository;

import org.springframework.data.repository.CrudRepository;

import com.vsm.devcase.model.Cliente;


/**
 * Repositório padrão (CRUD) do cadastro do cliente. 
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
}
