package com.JavaTaskFlow.controllers.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.JavaTaskFlow.services.exception.BadCredentialsException;
import com.JavaTaskFlow.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	 @ExceptionHandler(BadCredentialsException.class)
	    public ResponseEntity<StandardError> badCredentials(BadCredentialsException e, HttpServletRequest request) {
	        HttpStatus status = HttpStatus.UNAUTHORIZED;
	        StandardError err = new StandardError(
	            System.currentTimeMillis(), 
	            status.value(), 
	            "Credenciais inválidas", 
	            e.getMessage(), 
	            request.getRequestURI()
	        );
	        return ResponseEntity.status(status).body(err);
	    }
}
