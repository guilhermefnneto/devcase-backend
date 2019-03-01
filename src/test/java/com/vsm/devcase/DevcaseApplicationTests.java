package com.vsm.devcase;

import java.math.BigDecimal;
import java.math.BigInteger;
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
import com.vsm.devcase.model.Pontuacao;
import com.vsm.devcase.model.Sexo;
import com.vsm.devcase.model.Venda;

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
		
		URI uri = new URI(SERVER_HOST + "/cliente");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Roberto Finâncio");
		cliente.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("17/07/1970"));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefoneResidencial(14999998888L);
		cliente.setTelefoneCelular(14988889999L);
		cliente.setEmail("roberto.financio@gmail.com");
		cliente.setEstadoCivil(EstadoCivil.SOLTEIRO);
		cliente.setPontos(new BigInteger("0"));
		
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
		
		URI uri = new URI(SERVER_HOST + "/cliente/1");
		
		ResponseEntity<Cliente> response = rest.getForEntity(uri, Cliente.class);
				
		Assert.assertEquals(1L, (long)response.getBody().getId());
	}
    
    
    /**
     * Teste referente à atualização de um cliente.
     * @throws URISyntaxException
     * @throws ParseException
     */
    @Test
	public void updateCliente() throws URISyntaxException, ParseException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(SERVER_HOST + "/cliente/2");
		
		Cliente cliente = new Cliente();
		cliente.setTelefoneCelular(14977777777L);
		cliente.setEstadoCivil(EstadoCivil.CASADO);
		
		rest.put(uri, cliente);
		
		Assert.assertTrue(true);
	}
    
    
    /**
     * Teste referente à remoção de um cliente.
     * @throws URISyntaxException
     */
    @Test
	public void deleteCliente() throws URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(SERVER_HOST + "/cliente/3");
		
		rest.delete(uri);
		
		Assert.assertTrue(true);
		
	}
    
    
    /**
     * Teste referente à recuperação de todos os clientes.
     * @throws URISyntaxException
     */
    @Test
	public void readAllCliente() throws URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		
		URI uri = new URI(SERVER_HOST + "/cliente");
		
		ResponseEntity<Iterable> response = rest.getForEntity(uri, Iterable.class);
		
		Assert.assertNotEquals(null, response.getBody().iterator().next());
		
	}
    
    /* Finalização dos testes relacionados ao cliente. */
    
    
    
    
    
    
    
    /* Início dos testes relacionados à pontuação ... */
    
   
    /**
     * Teste referente à criação de uma pontuação.
     * @throws URISyntaxException
     */
    @Test
    public void createPontuacao() throws URISyntaxException {

    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/pontuacao");
    	
    	Pontuacao pontuacao = new Pontuacao();
    	pontuacao.setValorInicial(new BigDecimal("200.01"));
    	pontuacao.setValorFinal(new BigDecimal("250.0"));
    	pontuacao.setPontos(new BigInteger("25"));
    	
    	ResponseEntity<Pontuacao> response = rest.postForEntity(uri, pontuacao, Pontuacao.class);
    	
    	Assert.assertEquals(25L, response.getBody().getPontos().longValue());
    	
    }
   
    
    /**
     * Teste referente à recuperação de uma pontuação.
     * @throws URISyntaxException
     */
    @Test
    public void readPontuacao() throws URISyntaxException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/pontuacao/1");
    	
    	ResponseEntity<Pontuacao> response = rest.getForEntity(uri, Pontuacao.class);
    	
    	Assert.assertEquals((double)50.0, (double)response.getBody().getValorFinal().doubleValue(), 0);
    	
    }
    
    
    /**
     * Teste referente à atualização de uma pontuação.
     * @throws URISyntaxException
     */
    @Test
    public void updatePontuacao() throws URISyntaxException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/pontuacao/2");
    	
    	Pontuacao pontuacao = new Pontuacao();
    	pontuacao.setValorInicial(new BigDecimal("50.01"));
    	
    	rest.put(uri, pontuacao);
    	
    	Assert.assertTrue(true);
    	
    }
    
    
    /**
     * Teste referente à remoção de uma pontuação.
     * @throws URISyntaxException
     */
    @Test
    public void deletePontuacao() throws URISyntaxException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/pontuacao/3");
    	
    	rest.delete(uri);
    	
    	Assert.assertTrue(true);
    	
    }
    
    
    /**
     * Teste referente à recuperação de todas as pontuações.
     * @throws URISyntaxException
     */
    @Test
    public void readAllPontuacao() throws URISyntaxException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/pontuacao");
    	
    	ResponseEntity<Iterable> response = rest.getForEntity(uri, Iterable.class);
    	
    	Assert.assertTrue(response.getBody().iterator().hasNext());
    	
    }
    
    
    /* Finalização dos testes relacionados à pontuação. */
    
    
    
    
    
    
    /* Início dos testes relacionados à venda ... */
    
    
	/**
	 * Teste referente à criação de uma venda.
	 * @throws URISyntaxException
	 * @throws ParseException 
	 */
    @Test
    public void createVenda() throws URISyntaxException, ParseException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/venda");
    	
    	Cliente cliente = new Cliente();
    	cliente.setId(1L);
    	
    	Venda venda = new Venda();
    	venda.setCliente(cliente);
    	venda.setData(new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019"));
    	venda.setValor(new BigDecimal("220.0"));
    	
    	ResponseEntity<Venda> response = rest.postForEntity(uri, venda, Venda.class);
    	
    	Assert.assertNotNull(response.getBody());
    	
    }
    
    
    /**
     * Teste referente à recuperação das vendas de um determinado período.
     * @throws URISyntaxException
     */
    @Test
    public void readByPeriodoVenda() throws URISyntaxException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/venda/periodo?inicioperiodo=01/03/2019&fimperiodo=31/03/2019");
    	
    	ResponseEntity<Iterable> response = rest.getForEntity(uri.toString(), Iterable.class);
    	
    	Assert.assertTrue(response.getBody().iterator().hasNext());
    	
    }
    
    
    /**
     * Teste referente à recuperação das vendas feitas por um sexo e um determinado período.
     * @throws URISyntaxException
     */
    @Test
    public void readQuantidadeBySexoAndPeriodo() throws URISyntaxException {
    	
    	RestTemplate rest = new RestTemplate();
    	
    	URI uri = new URI(SERVER_HOST + "/venda/quantidade?sexo=MASCULINO&inicioperiodo=01/02/2019&fimperiodo=31/03/2019");
    	
    	ResponseEntity<BigInteger> response = rest.getForEntity(uri, BigInteger.class);
    	
    	Assert.assertTrue(response.getBody().longValue() > 0);
    	
    }
    
    
    /* Finalização dos testes relacionados à venda. */

}

