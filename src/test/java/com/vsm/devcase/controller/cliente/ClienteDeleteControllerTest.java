package com.vsm.devcase.controller.cliente;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteDeleteControllerTest {

	
	@Test
	public void delete() throws URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI("http://localhost:9000/cliente/14");
		
		rest.delete(uri);
		
		Assert.assertEquals(true, true);
		
	}
	
	
}
