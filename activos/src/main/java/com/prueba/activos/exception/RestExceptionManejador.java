package com.prueba.activos.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prueba.activos.model.Mensaje;

@RestControllerAdvice
public class RestExceptionManejador extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	private ResponseEntity<Mensaje> manejarEntityNotFound(EntityNotFoundException e) {
		Mensaje error = new Mensaje(HttpStatus.NOT_FOUND, "Entidad no encontrada", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<Mensaje> manejarConstraintViolationException(ConstraintViolationException e) {
		Mensaje error = new Mensaje(HttpStatus.NOT_ACCEPTABLE, "Valor nulo o blanco", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	private ResponseEntity<Mensaje> manejarMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		Mensaje error = new Mensaje(HttpStatus.NOT_ACCEPTABLE, "Formato de fecha incorrecta (usar yyyy-MM-dd)", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NullPointerException.class)
	private ResponseEntity<Mensaje> manejarNullPointerException(NullPointerException e) {
		Mensaje error = new Mensaje(HttpStatus.INTERNAL_SERVER_ERROR, "Atributo nulo encontrado", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	private ResponseEntity<Mensaje> manejarSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
		Mensaje error = new Mensaje(HttpStatus.INTERNAL_SERVER_ERROR, "ID de activo invalido", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	private ResponseEntity<Mensaje> manejarIllegalArgumentException(IllegalArgumentException e) {
		Mensaje error = new Mensaje(HttpStatus.NOT_ACCEPTABLE, "Tipo de asignacion invalido", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}

}
