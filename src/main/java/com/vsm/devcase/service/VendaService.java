package com.vsm.devcase.service;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsm.devcase.model.Pontuacao;
import com.vsm.devcase.model.Sexo;
import com.vsm.devcase.model.Venda;
import com.vsm.devcase.repository.VendaRepository;


/**
 * Serviço de gerenciamento dos dados da venda. 
 */
@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private PontuacaoService pontuacaoService;
	
	@Autowired
	private ClienteService clienteService;
	
	
	/**
	 * Método responsável pela criação de uma venda.
	 * No ato da venda, é feita a soma da pontuação para o cliente que realizou a venda.
	 * @param venda A venda que será registrada.
	 * @return A venda registrada, caso contrário, null.
	 */
	public Venda create(Venda venda) {
		Venda vendaGravada = vendaRepository.save(venda);
		
		Pontuacao pontuacao = pontuacaoService.readByIntervalValor(venda.getValor());
		if (pontuacao == null) {
			return null;
		}
		
		clienteService.sumPontos(venda.getCliente().getId(), pontuacao.getPontos());
				
		return vendaGravada;
	}
	
	
	/**
	 * Método responsável por recuperar todas as vendas realizadas em determinado período.
	 * @param inicioPeriodo Indica o início do período.
	 * @param fimPeriodo Indica o fim do período.
	 * @return A lista de vendas realizadas em determinado período.
	 */
	public Iterable<Venda> readByPeriodo(Date inicioPeriodo, Date fimPeriodo) {
		return vendaRepository.readByPeriodo(inicioPeriodo, fimPeriodo);
	}
	
	
	/**
	 * Método responsável por recuperar todas as vendas realizadas por um sexo e em determinado período.
	 * @param sexo
	 * @param inicioPeriodo Indica o início do período.
	 * @param fimPeriodo Indica o fim do período.
	 * @return A lista de vendas realizadas por um sexo e em determinado período.
	 */
	public BigInteger readQuantidadeBySexoAndPeriodo(Sexo sexo, Date inicioPeriodo, Date fimPeriodo) {
		return vendaRepository.readQuantidadeBySexoAndPeriodo(sexo, inicioPeriodo, fimPeriodo);
	}
	
	
}
