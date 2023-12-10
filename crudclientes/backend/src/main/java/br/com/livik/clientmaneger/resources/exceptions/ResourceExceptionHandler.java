package br.com.livik.clientmaneger.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.livik.clientmaneger.services.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
		return ResponseEntity.ok(new StandardError(Instant.now(),
		HttpStatus.NOT_FOUND.value(), "Cliente não encontrado na base de dados",
		e.getMessage(), request.getRequestURI()));
	}
}
