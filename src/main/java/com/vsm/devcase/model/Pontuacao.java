package com.vsm.devcase.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="pontuacao")
public class Pontuacao {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private BigInteger pontos;
	
	@Column(nullable=false)
	private BigDecimal valorInicial;
	
	@Column(nullable=false)
	private BigDecimal valorFinal;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getPontos() {
		return pontos;
	}

	public void setPontos(BigInteger pontos) {
		this.pontos = pontos;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
