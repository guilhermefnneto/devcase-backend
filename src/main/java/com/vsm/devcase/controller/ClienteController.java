package com.vsm.devcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsm.devcase.model.Cliente;
import com.vsm.devcase.service.ClienteService;


/**
 * Gerenciador do cadastro de cliente.
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

	
	/**
	 * Representante dos serviços do cliente.
	 */
	@Autowired
	private ClienteService clienteService;
	
	
	
	/**
	 * Cadastra o cliente.
	 * @param cliente O POJO com todas as informações do cliente.
	 * @return o POJO do cliente cadastrado.
	 */
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.create(cliente));
	}
	
	
	/**
	 * Recupera o cliente pelo seu id.
	 * @param id O identificador do cliente a ser recuperado.
	 * @return O POJO do cliente recuperado, se não, a informação de que não foi encontrado.
	 */
	@GetMapping(value="{id}")
	public ResponseEntity<Cliente> read(@PathVariable("id") Long id) {
		Cliente clienteEncontrado = clienteService.read(id);
		
		return clienteEncontrado != null ?ResponseEntity.ok(clienteEncontrado) :ResponseEntity.notFound().build();
	}
	
	
	/**
	 * Atualiza as informações do cliente.
	 * @param id O id do cliente a ser atualizado.
	 * @param cliente O POJO com todas as informações do cliente, inclusive as já atualizadas.
	 * @return O POJO do cliente alterado, se não a informação de que não foi encontrado.
	 */
	@PutMapping(value="{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.update(id, cliente);
		
		return clienteAtualizado != null ?ResponseEntity.ok(clienteAtualizado) :ResponseEntity.notFound().build();
	}
	
	
	
	/**
	 * Remove o cliente correspondente ao id informado.
	 * @param id O id do cliente a ser removido.
	 * @return O POJO do cliente removido, se não a informação de que não foi encontrado.
	 */
	@DeleteMapping(value="{id}")
	public @ResponseBody ResponseEntity<Cliente> delete(@PathVariable("id") Long id) {
		Cliente clienteRemovido = clienteService.delete(id);
		
		return clienteRemovido != null ?ResponseEntity.ok(clienteRemovido) :ResponseEntity.notFound().build();
	}
	
	
	/**
	 * Recupera todos os clientes.
	 * @return Uma lista com todos os clientes cadastrados.
	 */
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> readAll() {
		return ResponseEntity.ok(clienteService.readAll());
	}
	
	
}
