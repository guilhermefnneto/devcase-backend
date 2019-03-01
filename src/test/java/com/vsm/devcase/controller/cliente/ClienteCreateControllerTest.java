package com.vsm.devcase.controller.cliente;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.vsm.devcase.DevcaseApplicationTests;
import com.vsm.devcase.model.Cliente;
import com.vsm.devcase.model.EstadoCivil;
import com.vsm.devcase.model.Sexo;


/**
 * Teste do gerenciamento do cliente: funcionalidade de criação de um cliente.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteCreateControllerTest {

	
	@Test
	public void create() throws URISyntaxException, ParseException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Roberto Finâncio");
		cliente.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("17/07/1970"));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefoneResidencial(14999998888L);
		cliente.setTelefoneCelular(14988889999L);
		cliente.setEmail("roberto.financio@gmail.com");
		cliente.setEstadoCivil(EstadoCivil.SOLTEIRO);
		cliente.setPontos(0L);
		
		ResponseEntity<Cliente> response = rest.postForEntity(uri, cliente, Cliente.class);
		
		Assert.assertNotNull(response.getBody());
		
	}
	
	
}
