package br.com.senai.task.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import br.com.senai.task.utils.exceptions.error.Error;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Error> handleNotFoundException(RuntimeException ex) {
    
    Error error = new Error();
    error.setMessage(ex.getMessage());
    error.setReason(HttpStatus.NOT_FOUND.getReasonPhrase());
    error.setStatusCode(HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Error> handleBusinessExeption(RuntimeException ex) {
    
    Error error = new Error();
    error.setMessage(ex.getMessage());
    error.setReason(HttpStatus.BAD_REQUEST.getReasonPhrase());
    error.setStatusCode(HttpStatus.BAD_REQUEST);
    error.setField("");

   return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<Error> handleConflictException(RuntimeException ex) {
    
    Error error = new Error();
    error.setMessage(ex.getMessage());
    error.setReason(HttpStatus.CONFLICT.getReasonPhrase());
    error.setStatusCode(HttpStatus.CONFLICT);
    error.setField("");

   return new ResponseEntity<>(error, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(InternalServerError.class)
  public ResponseEntity<Error> handleGenericException(Exception ex) {
    
    Error error = new Error();
    error.setMessage(ex.getMessage());
    error.setReason(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
    error.setField("");

   return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}