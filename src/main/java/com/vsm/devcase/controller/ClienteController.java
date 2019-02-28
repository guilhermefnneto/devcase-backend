package com.vsm.devcase.controller;

import java.util.Optional;

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

import com.vsm.devcase.model.Cliente;
import com.vsm.devcase.repository.ClienteRepository;


/**
 * Gerenciador do cadastro de cliente.
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	/**
	 * Cadastra o cliente.
	 * @param cliente O POJO com todas as informações do cliente.
	 * @return o POJO do cliente cadastrado.
	 */
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	
	/**
	 * Recupera o cliente pelo seu id.
	 * @param id O identificador do cliente no cadastro.
	 * @return O POJO do cliente recuperado.
	 */
	@GetMapping(value="{id}")
	public ResponseEntity<Cliente> read(@PathVariable("id") Long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		
		if (!optionalCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optionalCliente.get());
	}
	
	
	/**
	 * Altera as informações do cliente.
	 * @param cliente O POJO com todas as informações do cliente, inclusive as já alteradas.
	 * @return O POJO do cliente alterado.
	 */
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		Optional<Cliente> optionalClienteRecuperado = clienteRepository.findById(cliente.getId());
		
		if (!optionalClienteRecuperado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente clienteRecuperado = optionalClienteRecuperado.get();
		clienteRecuperado.copyFrom(cliente);
		
		return ResponseEntity.ok(clienteRepository.save(clienteRecuperado));
	}
	
	
	
	/**
	 * Remove o cliente correspondente ao id informado.
	 * @param id O id do cliente a ser removido.
	 * @return O POJO do cliente removido.
	 */
	@DeleteMapping
	public ResponseEntity<Cliente> delete(@PathVariable("id") Long id) {
		Optional<Cliente> optionalClienteRecuperado = clienteRepository.findById(id);
		
		if (!optionalClienteRecuperado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	
}
