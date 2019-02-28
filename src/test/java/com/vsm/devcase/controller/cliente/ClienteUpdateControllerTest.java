package com.vsm.devcase.controller.cliente;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.vsm.devcase.model.Cliente;
import com.vsm.devcase.model.EstadoCivil;


/**
 * Teste do gerenciamento do cliente: funcionalidade de atualização de um cliente. 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteUpdateControllerTest {

	
	@Test
	public void update() throws URISyntaxException, ParseException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI("http://localhost:9000/cliente");
		
		Cliente cliente = new Cliente();
		cliente.setId(14L);
		cliente.setTelefoneCelular(14977777777L);
		cliente.setEstadoCivil(EstadoCivil.CASADO);
		
		rest.put(uri, cliente);
		
		Assert.assertEquals(true, true);
	}
	
	
}
