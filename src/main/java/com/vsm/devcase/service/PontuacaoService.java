package com.vsm.devcase.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsm.devcase.model.Pontuacao;
import com.vsm.devcase.repository.PontuacaoRepository;


/**
 * Serviço de gerenciamento dos dados da pontuação. 
 */
@Service
public class PontuacaoService {

	
	/**
	 * Representação de acesso ao repositório da pontuação.
	 */
	@Autowired
	private PontuacaoRepository pontuacaoRepository;
	

	/**
	 * Método responsável pela criação de uma pontuação.
	 * @param pontuacao O POJO com todos os dados da pontuação.
	 * @return O POJO da pontuação incluída no repositório.
	 */
	public Pontuacao create(Pontuacao pontuacao) {
		return pontuacaoRepository.save(pontuacao);
	}
	
	
	/**
	 * Método responsável por recuperar uma pontuação do repositório.
	 * @param id Id da pontuação a ser recuperada.
	 * @return A pontuação recuperada ou null caso não tenha sido encontrada.
	 */
	public Pontuacao read(Long id) {
		Optional<Pontuacao> optionalPontuacaoRecuperada = pontuacaoRepository.findById(id);
		
		if (!optionalPontuacaoRecuperada.isPresent()) {
			return null;
		}
		
		return optionalPontuacaoRecuperada.get();
	}
	
	
	/**
	 * Método responsável por atualizar as informações da pontuação identificada.
	 * @param id Id da pontuação a ser recuperada.
	 * @param pontuacao POJO da pontuação contendo as informações de atualização.
	 * @return O POJO da pontuação atualizada. Caso a pontuação não tenha sido encontrada, ou não tenha sido atualizada, o retorno será null.
	 */
	public Pontuacao update(Long id, Pontuacao pontuacao) {
		Optional<Pontuacao> optionalPontuacaoRecuperada = pontuacaoRepository.findById(id);
		
		if (!optionalPontuacaoRecuperada.isPresent()) {
			return null;
		}
		
		
		Pontuacao pontuacaoRecuperada = optionalPontuacaoRecuperada.get();
		
		if (!copyFromTo(pontuacao, pontuacaoRecuperada)) {
			return null;
		}
		
		
		return pontuacaoRepository.save(pontuacaoRecuperada);
		
	}
	
	
	/**
	 * Método responsável pela remoção da pontuação no repositório.
	 * @param id Id da pontuação a ser removida.
	 * @return true caso a pontuação tenha sido removida, e false caso contrário.
	 */
	public Boolean delete(Long id) {
		Optional<Pontuacao> optionalPontuacaoRecuperada = pontuacaoRepository.findById(id);
		
		if (!optionalPontuacaoRecuperada.isPresent()) {
			return false;
		}
		
		pontuacaoRepository.delete(optionalPontuacaoRecuperada.get());
		
		return true;
	}
	
	
	/**
	 * Método responsável por recuperar do repositório todas as pontuações cadastradas.
	 * @return Uma lista com todas as pontuações cadastradas.
	 */
	public Iterable<Pontuacao> readAll() {
		return pontuacaoRepository.findAll();
	}
	
	
	/**
	 * Método responsável por recuperar uma pontuação pelo valor encontrado em um intervalo de valores da pontuação.
	 * @param valor O valor a ser utilizado como referência.
	 * @return A pontuação encontrada ou null caso contrário.
	 */
	public Pontuacao readByIntervalValor(BigDecimal valor) {
		return pontuacaoRepository.readByIntervalValores(valor);
	}
	
	
	/**
	 * Copia os dados do cliente passado como argumento 1º argumento para o objeto do cliente passado como 2º argumento.
	 * Apenas o id e os dados nulos não são copiados.
	 * @param pontuacaoFrom O objeto que contém as informações a serem copiadas.
	 * @param pontuacaoTo O objeto para onde as informações serão copiadas.
	 * @return Caso um dos dois objetos seja null, o retorno será false, se não, será true.
	 */
	protected boolean copyFromTo(Pontuacao pontuacaoFrom, Pontuacao pontuacaoTo) {
		if (pontuacaoFrom == null || pontuacaoTo == null) return false;
		
		if (pontuacaoFrom.getValorInicial()    != null) pontuacaoTo.setValorInicial (pontuacaoFrom.getValorInicial());
		if (pontuacaoFrom.getValorFinal()      != null) pontuacaoTo.setValorFinal   (pontuacaoFrom.getValorFinal());
		if (pontuacaoFrom.getPontos()          != null) pontuacaoTo.setPontos       (pontuacaoFrom.getPontos());
		
		return true;
	}
	
}
