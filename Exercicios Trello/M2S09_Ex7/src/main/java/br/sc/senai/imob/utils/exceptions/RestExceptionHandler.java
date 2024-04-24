package br.sc.senai.imob.utils.exceptions;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import br.sc.senai.imob.utils.exceptions.error.Error;

@RestControllerAdvice
public class RestExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Error> handleBusinessExeption(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);

    BusinessException exception = (BusinessException) ex;

   return new ResponseEntity<>(exception.getError(), HttpStatus.BAD_REQUEST);
  }

  
  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<Error> handleConflictException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);

    ConflictException exception = (ConflictException) ex;

   return new ResponseEntity<>(exception.getError(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Error> handleNotFoundException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);
  
    NotFoundException exception = (NotFoundException) ex;

    return new ResponseEntity<>(exception.getError(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<Error> handleNullPointerException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);

    NullPointerException exception = (NullPointerException) ex;
    
   return new ResponseEntity<>(exception.getError(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InternalServerError.class)
  public ResponseEntity<Error> handleGenericException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);

    Error error = Error.builder()
      .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
      .message(ex.getMessage())
      .build();

   return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(InvocationTargetException.class)
  public ResponseEntity<Error> handleInvocationTargetException(Exception ex) {
    LOGGER.error(ex.getMessage(), ex);

    Error error = Error.builder()
      .statusCode(HttpStatus.BAD_REQUEST)
      .message(ex.getMessage())
      .build();

   return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}