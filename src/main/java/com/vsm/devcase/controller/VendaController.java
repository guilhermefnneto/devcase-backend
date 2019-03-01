package com.vsm.devcase.controller;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vsm.devcase.model.Sexo;
import com.vsm.devcase.model.Venda;
import com.vsm.devcase.service.VendaService;
import com.vsm.devcase.validation.VendaValidation;


@Controller
@RequestMapping("/venda")
public class VendaController {

	
	@Autowired
	private VendaService vendaService;
	
	
	/**
	 * Configuração do objeto que cuidará da validação da venda.
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new VendaValidation());
	}
	
	
	/**
	 * Registra a venda.
	 * @param venda A venda a ser registrada.
	 * @return A venda registrada, ou null, caso contrário.
	 */
	@PostMapping
	public ResponseEntity<Venda> create(@RequestBody @Valid Venda venda) {
		return ResponseEntity.ok(vendaService.create(venda));
	}
	
	
	/**
	 * Recupera as vendas de um período.
	 * @param inicioPeriodo Indica o início do período.
	 * @param fimPeriodo Indica o fim do período.
	 * @return Retora a lista com as vendas recuperadas.
	 */
	@GetMapping("/periodo")
	public ResponseEntity<Iterable<Venda>> readByPeriodo(@RequestParam("inicioperiodo") @DateTimeFormat(pattern="dd/MM/yyyy") Date inicioPeriodo
													   , @RequestParam("fimperiodo")  @DateTimeFormat(pattern="dd/MM/yyyy") Date fimPeriodo) {
		return ResponseEntity.ok(vendaService.readByPeriodo(inicioPeriodo, fimPeriodo));
	}
	
	
	/**
	 * Recupera as vendas realizas por um sexo em um período.
	 * @param sexo Indica o sexo do cliente
	 * @param inicioPeriodo Indica o início do período.
	 * @param fimPeriodo Indica o fim do período.
	 * @return Retora a lista com as vendas recuperadas.
	 */
	@GetMapping("/quantidade")
	public ResponseEntity<BigInteger> readQuantidadeBySexoAndPeriodo(@RequestParam("sexo") Sexo sexo
																	, @RequestParam("inicioperiodo") @DateTimeFormat(pattern="dd/MM/yyyy") Date inicioPeriodo
																	, @RequestParam("fimperiodo")  @DateTimeFormat(pattern="dd/MM/yyyy") Date fimPeriodo) {
		
		BigInteger quantidade = vendaService.readQuantidadeBySexoAndPeriodo(sexo, inicioPeriodo, fimPeriodo);
		
		return ResponseEntity.ok(quantidade);
	}
	
	
}
