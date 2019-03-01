package com.vsm.devcase.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="venda")
public class Venda {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/* Váras vendas podem ser feitas para um mesmo cliente. */
	@ManyToOne
	private Cliente cliente;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable=false)
	private BigDecimal valor;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
