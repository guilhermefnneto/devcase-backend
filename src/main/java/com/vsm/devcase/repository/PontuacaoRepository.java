package com.vsm.devcase.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vsm.devcase.model.Pontuacao;


/**
 * Repositório padrão (CRUD) do cadastro da pontuação. 
 */
public interface PontuacaoRepository extends CrudRepository<Pontuacao, Long> {

	/**
	 * Recupera a pontuação a partir do valor que se encontra entre os valores inicial e final de uma pontuação.
	 * @param valor
	 * @return
	 */
	@Query("SELECT p FROM pontuacao p WHERE p.valorInicial <= :valor AND p.valorFinal >= :valor")
	Pontuacao readByIntervalValores(@Param("valor") BigDecimal valor);
	
}
