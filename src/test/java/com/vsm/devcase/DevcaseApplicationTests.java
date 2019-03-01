package com.vsm.devcase;

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

import com.vsm.devcase.model.Cliente;
import com.vsm.devcase.model.EstadoCivil;
import com.vsm.devcase.model.Sexo;

/**
 * Classe responsável pela execução dos testes da aplicação, do lado do servidor.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DevcaseApplicationTests {
	
	
	public static final String SERVER_HOST = "http://localhost:9000";
	
	
//    @Test
//    public void contextLoads() {
//    }
    
	
	
	
	
    
	/* Início dos testes relacionados ao cliente ... */
	
	/**
	 * Teste referente à criação de um cliente.
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	@Test
	public void createCliente() throws URISyntaxException, ParseException {
		
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
    
    
	/**
	 * Teste referente à recuperação de um cliente.
	 * @throws URISyntaxException
	 */
    @Test
	public void readCliente() throws URISyntaxException {
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente/13");
		
		ResponseEntity<Cliente> response = rest.getForEntity(uri, Cliente.class);
				
		Assert.assertEquals("Juliana Marques", response.getBody().getNome());
	}
    
    
    /**
     * Teste referente à atualização de um cliente.
     * @throws URISyntaxException
     * @throws ParseException
     */
    @Test
	public void updateCliente() throws URISyntaxException, ParseException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente/27");
		
		Cliente cliente = new Cliente();
		cliente.setId(25L);
		cliente.setTelefoneCelular(14977777777L);
		cliente.setEstadoCivil(EstadoCivil.CASADO);
		
		rest.put(uri, cliente);
		
		Assert.assertEquals(true, true);
	}
    
    
    /**
     * Teste referente à remoção de um cliente.
     * @throws URISyntaxException
     */
    @Test
	public void deleteCliente() throws URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente/24");
		
		rest.delete(uri);
		
		Assert.assertEquals(true, true);
		
	}
    
    
    /**
     * Teste referente à recuperação de todos os clientes.
     * @throws URISyntaxException
     */
    @Test
	public void readAllCliente() throws URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(DevcaseApplicationTests.SERVER_HOST + "/cliente");
		
		ResponseEntity<Iterable> response = rest.getForEntity(uri, Iterable.class);
		
		Assert.assertNotEquals(null, response.getBody().iterator().next());
		
	}
    
    /* Finalização dos testes relacionados ao cliente. */
    
    
    
    
    
    
    
    /* Início dos testes relacionados à pontuação ... */
    
    /* Finalização dos testes relacionados à pontuação. */
    

}

