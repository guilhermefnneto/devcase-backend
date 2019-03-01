package com.vsm.devcase.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vsm.devcase.model.Cliente;


/**
 * Representante de validação dos dados do cliente.
 */
public class ClienteValidation implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome"            , "field.required");
		ValidationUtils.rejectIfEmpty            (errors, "dataNascimento"  , "field.required");
		ValidationUtils.rejectIfEmpty            (errors, "sexo"            , "field.required");
		ValidationUtils.rejectIfEmpty            (errors, "telefoneCelular" , "field.required");
		ValidationUtils.rejectIfEmpty            (errors, "estadoCivil"     , "field.required");
		
	}

	
	
}
