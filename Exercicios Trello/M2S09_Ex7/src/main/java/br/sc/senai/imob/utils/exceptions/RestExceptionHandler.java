package br.sc.senai.imob.utils.exceptions;


import br.sc.senai.imob.utils.exceptions.error.Error;
import jakarta.validation.ConstraintViolationException;

import java.util.HashMap;
import java.util.Map;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ExceptionHandler(InternalServerError.class)
  public ResponseEntity<Error> handleGenericException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);

    Error error = Error.builder()
      .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
      .message(ex.getMessage())
      .build();

   return new ResponseEntity<>(error, error.getStatusCode());
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Error> handleNotFoundException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);
  
    NotFoundException exception = (NotFoundException) ex;

    return new ResponseEntity<>(exception.getError(), exception.getError().getStatusCode());
  }
  
  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
    LOGGER.error(ex.getMessage(), ex);

    Error error = Error.builder()
      .statusCode(HttpStatus.BAD_REQUEST)
      .message(ex.getMessage())
      .build();

      ex.getConstraintViolations().forEach(constraints -> {
            error.addDetail(constraints.getMessage(), constraints.getPropertyPath().iterator().next().getName());
      });
    return new ResponseEntity<>(error, error.getStatusCode());
  }
 
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    LOGGER.error(ex.getMessage(), ex);

    Error error = Error.builder()
      .message(ex.getMessage())
      .statusCode(HttpStatus.BAD_REQUEST)
      .build();
      
    ex.getBindingResult().getAllErrors().forEach(e -> error.addDetail( e.getDefaultMessage(), ((FieldError) e).getField()));
    
    return new ResponseEntity<>(error, error.getStatusCode());
  }


  @Override
  public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    LOGGER.error(ex.getMessage(), ex);

    Error error = Error.builder()
      .message(ex.getMessage())
      .statusCode(HttpStatus.BAD_REQUEST)
      .build();
    
    return new ResponseEntity<>(error, error.getStatusCode());
  }
}