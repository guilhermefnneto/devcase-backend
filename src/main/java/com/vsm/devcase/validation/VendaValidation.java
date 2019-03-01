package com.vsm.devcase.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vsm.devcase.model.Venda;


/**
 * Representante de validação dos dados da venda.
 */
public class VendaValidation implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Venda.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		
		Venda venda = (Venda) target;
		
		ValidationUtils.rejectIfEmpty(errors, "cliente", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "data", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "valor", "field.required");
		
		if (venda.getValor() != null && venda.getValor().doubleValue() < 0.0) errors.rejectValue("valor", "negativevalue");
		
	}

	
	
}
