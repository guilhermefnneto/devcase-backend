package com.vsm.devcase.controller.cliente;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.vsm.devcase.DevcaseApplicationTests;
import com.vsm.devcase.model.Cliente;


/**
 * Teste do gerenciamento do cliente: funcionalidade de recuperação de um cliente.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteReadControllerTest {
	
	
	@Test
	public void read() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente/13");
		
		ResponseEntity<Cliente> response = rest.getForEntity(uri, Cliente.class);
				
		Assert.assertEquals("Juliana Marques", response.getBody().getNome());
	}
	

}
