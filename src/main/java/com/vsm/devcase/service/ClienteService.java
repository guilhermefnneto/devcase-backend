package com.vsm.devcase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsm.devcase.model.Cliente;
import com.vsm.devcase.repository.ClienteRepository;


/**
 * Serviço de gerenciamento dos dados do cliente. 
 */
@Service
public class ClienteService {

	/**
	 * Representação de acesso ao repositório do cliente.
	 */
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	/**
	 * Método responsável pela criação de um cliente. 
	 * @param cliente O POJO com todos os dados do cliente.
	 * @return O POJO do cliente incluído no repositório.
	 */
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	/**
	 * Método responsável por recuperar um cliente do repositório.
	 * @param id Id do cliente a ser recuperado.
	 * @return O cliente recuperado ou null caso não tenha sido encontrado.
	 */
	public Cliente read(Long id) {
		Optional<Cliente> optionalClienteRecuperado = clienteRepository.findById(id);
		
		return optionalClienteRecuperado.isPresent() ?optionalClienteRecuperado.get() :null;
	}
	
	
	/**
	 * Método responsável por atualizar as informações do cliente identificado.
	 * @param id Id do cliente a ser recuperado.
	 * @param cliente POJO do cliente contendo as informações de atualização.
	 * @return O POJO do cliente atualizado. Caso o cliente não tenha sido encontrado, ou não tenha sido atualizado, o retorno será null.
	 */
	public Cliente update(Long id, Cliente cliente) {
		Optional<Cliente> optionalClienteRecuperado = clienteRepository.findById(id);
		
		if (!optionalClienteRecuperado.isPresent()) {
			return null;
		}
		
		Cliente clienteRecuperado = optionalClienteRecuperado.get();
		
		if (!copyFromTo(cliente, clienteRecuperado)) {
			return null;
		}
		
		return clienteRepository.save(clienteRecuperado);
	}
	
	
	/**
	 * Método responsável pela remoção do cliente no repositório.
	 * @param id Id do cliente a ser removido.
	 * @return O cliente removido ou null caso não tenha sido encontrado.
	 */
	public Cliente delete(Long id) {
		Optional<Cliente> optionalClienteRecuperado = clienteRepository.findById(id);
		
		if (!optionalClienteRecuperado.isPresent()) {
			return null;
		}
		
		clienteRepository.delete(optionalClienteRecuperado.get());
		
		return optionalClienteRecuperado.get();
	}
	
	
	/**
	 * Método responsável por recuperar do repositório todos os clientes cadastrados.
	 * @return Uma lista com todos os clientes cadastrados.
	 */
	public Iterable<Cliente> readAll() {
		return clienteRepository.findAll();
	}
	
	
	
	
	/**
	 * Copia os dados do cliente passado como argumento 1º argumento para o objeto do cliente passado como 2º argumento.
	 * Apenas o id e os dados nulos não são copiados.
	 * @param clienteFrom O objeto que contém as informações a serem copiadas.
	 * @param clinteTo O objeto para onde as informações serão copiadas.
	 * @return boolean Caso um dos dois objetos seja null, o retorno será false, se não, será true.
	 */
	protected boolean copyFromTo(Cliente clienteFrom, Cliente clienteTo) {
		if (clienteFrom == null || clienteTo == null) return false;
		
		if (clienteFrom.getNome()                 != null) clienteTo.setNome                 (clienteFrom.getNome());
		if (clienteFrom.getNascimento()           != null) clienteTo.setNascimento           (clienteFrom.getNascimento());
		if (clienteFrom.getSexo()                 != null) clienteTo.setSexo                 (clienteFrom.getSexo());
		if (clienteFrom.getTelefoneResidencial()  != null) clienteTo.setTelefoneResidencial  (clienteFrom.getTelefoneResidencial());
		if (clienteFrom.getTelefoneCelular()      != null) clienteTo.setTelefoneCelular      (clienteFrom.getTelefoneCelular());
		if (clienteFrom.getEmail()                != null) clienteTo.setEmail                (clienteFrom.getEmail());
		if (clienteFrom.getEstadoCivil()          != null) clienteTo.setEstadoCivil          (clienteFrom.getEstadoCivil());
		if (clienteFrom.getPontos()               != null) clienteTo.setPontos               (clienteFrom.getPontos());
		
		return true;
	}
	
}
