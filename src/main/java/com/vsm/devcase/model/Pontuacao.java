package com.vsm.devcase.model;

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
	private Integer pontos;
	
	@Column(nullable=false)
	private Double valorInicial;
	
	private Double valorFinal;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	public Double getValorFinal() {
		return valorFinal;
	}
	
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
