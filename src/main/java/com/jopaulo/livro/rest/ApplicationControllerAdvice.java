package com.jopaulo.livro.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.jopaulo.livro.rest.exception.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindResult = ex.getBindingResult();
		List<String> messages = bindResult.getAllErrors()
				.stream()
				.map(ObjectError -> ObjectError.getDefaultMessage())
				.collect(Collectors.toList());
		return new ApiErrors(messages);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {
		String msgErro = ex.getMessage();
		HttpStatus codStatus = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(msgErro);
		return new ResponseEntity(apiErrors, codStatus);
	}

}
