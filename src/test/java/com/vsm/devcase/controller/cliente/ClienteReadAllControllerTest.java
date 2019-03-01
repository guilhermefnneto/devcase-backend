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


/**
 * Teste do gerenciamento do cliente: funcionalidade de recuperação de todos os cliente.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteReadAllControllerTest {

	
	@Test
	public void readAll() throws URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente");
		
		ResponseEntity<Iterable> response = rest.getForEntity(uri, Iterable.class);
		
		Assert.assertNotEquals(null, response.getBody().iterator().next());
		
	}
	
	
}
