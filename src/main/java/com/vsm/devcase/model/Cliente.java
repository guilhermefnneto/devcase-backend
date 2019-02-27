package com.vsm.devcase.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="cliente")
public class Cliente {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	private Long telefoneResidencial;
	
	private Long telefoneCelular;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	private Long pontos;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Long getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(Long telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public Long getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(Long telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Long getPontos() {
		return pontos;
	}
	
	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}
	
}
