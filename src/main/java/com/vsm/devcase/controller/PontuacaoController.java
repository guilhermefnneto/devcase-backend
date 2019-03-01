package com.vsm.devcase.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsm.devcase.model.Pontuacao;
import com.vsm.devcase.service.PontuacaoService;
import com.vsm.devcase.validation.PontuacaoValidation;


/**
 * Gerenciador do cadastro de pontuação. 
 */
@Controller
@RequestMapping("/pontuacao")
public class PontuacaoController {

	
	/**
	 * Representante dos serviços da pontuação.
	 */
	@Autowired
	private PontuacaoService pontuacaoService;
	
	
	
	/**
	 * Configuração do objeto que cuidará da validação da pontuação.
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new PontuacaoValidation());
	}
	
	
	
	/**
	 * Cadastra a pontuação.
	 * @param pontuacao O POJO com todas as informações da pontuação.
	 * @return O POJO da pontuação cadastrada.
	 */
	@PostMapping
	public ResponseEntity<Pontuacao> create(@RequestBody @Valid Pontuacao pontuacao) {
		return ResponseEntity.ok(pontuacaoService.create(pontuacao));
	}
	
	
	/**
	 * Recupera a pontuação pelo seu id.
	 * @param id O identificador da pontuação a ser recuperada.
	 * @return O POJO da pontuação recuperada, se não, a informação de que não foi encontrada.
	 */
	@GetMapping(value="{id}")
	public ResponseEntity<Pontuacao> read(@PathVariable("id") Long id) {
		Pontuacao pontuacaoRecuperada = pontuacaoService.read(id);
		
		return pontuacaoRecuperada != null ?ResponseEntity.ok(pontuacaoRecuperada) :ResponseEntity.notFound().build();
	}
	
	
	/**
	 * Atualiza as informações da pontuação.
	 * @param id O id da pontuação a ser atualizada.
	 * @param pontuacao O POJO com todas as informações da pontuação, inclusive as já atualizadas.
	 * @return O POJO da pontuação atualizada, se não a informação de que não foi encontrada.
	 */
	@PutMapping(value="{id}")
	public ResponseEntity<Pontuacao> update(@PathVariable("id") Long id, @RequestBody Pontuacao pontuacao) {
		Pontuacao pontuacaoAtualizada = pontuacaoService.update(id, pontuacao);
		
		return pontuacaoAtualizada != null ?ResponseEntity.ok(pontuacaoAtualizada) :ResponseEntity.notFound().build();
	}
	
	
	/**
	 * Remove a pontuação correspondente ao id informado.
	 * @param id O id da pontuação a ser removida.
	 * @return true indicando que a pontuação foi removida, se não a informação de que não foi encontrada.
	 */
	@DeleteMapping(value="{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		Boolean pontuacaoRemovida = pontuacaoService.delete(id);
		
		return pontuacaoRemovida ?ResponseEntity.ok(pontuacaoRemovida) :ResponseEntity.notFound().build();
	}
	
	
	/**
	 * Recupera todas as pontuações.
	 * @return Uma lista com todas as pontuações cadastradas.
	 */
	@GetMapping
	public ResponseEntity<Iterable<Pontuacao>> readAll() {
		return ResponseEntity.ok(pontuacaoService.readAll());
	}
	
	
}
