package com.vsm.devcase.repository;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vsm.devcase.model.Sexo;
import com.vsm.devcase.model.Venda;


/**
 * Representação do acesso ao respositório das vendas. 
 */
public interface VendaRepository extends CrudRepository<Venda, Long> {

	
	@Query("SELECT v FROM venda v WHERE v.data between :inicioperiodo and :fimperiodo")
	Iterable<Venda> readByPeriodo(@Param("inicioperiodo") Date inicioPeriodo, @Param("fimperiodo") Date fimPeriodo);
	

	@Query("SELECT count(v) FROM venda v WHERE v.cliente.sexo = :sexo AND v.data between :inicioperiodo and :fimperiodo")
	BigInteger readQuantidadeBySexoAndPeriodo(@Param("sexo") Sexo sexo, @Param("inicioperiodo") Date inicioPeriodo, @Param("fimperiodo") Date fimPeriodo);
	
}
