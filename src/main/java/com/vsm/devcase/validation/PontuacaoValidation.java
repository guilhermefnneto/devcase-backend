package com.vsm.devcase.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vsm.devcase.model.Pontuacao;


/**
 * Representante da validação dos dados da pontuação. 
 */
public class PontuacaoValidation implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Pontuacao.class.isAssignableFrom(clazz);
	}
	

	@Override
	public void validate(Object target, Errors errors) {
		Pontuacao pontuacao = (Pontuacao) target;
		
		ValidationUtils.rejectIfEmpty(errors, "valorInicial" , "field.required");
		ValidationUtils.rejectIfEmpty(errors, "valorFinal"   , "field.required");
		ValidationUtils.rejectIfEmpty(errors, "pontos"       , "field.required");
		
		if (pontuacao.getValorInicial() != null && pontuacao.getValorInicial().doubleValue()  < 0.0) errors.rejectValue("valorInicial" , "negativevalue");
		if (pontuacao.getValorFinal()   != null && pontuacao.getValorFinal().doubleValue()    < 0.0) errors.rejectValue("valorFinal"   , "negativevalue");
		if (pontuacao.getPontos()       != null && pontuacao.getPontos().doubleValue()        < 0.0) errors.rejectValue("pontos"       , "negativevalue");
	}

	
	
}
