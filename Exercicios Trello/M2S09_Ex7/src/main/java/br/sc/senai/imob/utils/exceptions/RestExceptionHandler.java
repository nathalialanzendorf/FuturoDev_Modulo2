package br.sc.senai.imob.utils.exceptions;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Conflict;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.sc.senai.imob.utils.exceptions.error.Error;


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

    public ResponseEntity<Error> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
      LOGGER.error(ex.getMessage(), ex);

      Error error = Error.builder()
        .statusCode(HttpStatus.BAD_REQUEST)
        .message(ex.getMessage())
        .build();

      ex.getBindingResult().getAllErrors().forEach((e) -> {
        error.addDetail(e.getDefaultMessage(), ((FieldError) e).getField());
      });

      return new ResponseEntity<>(error, error.getStatusCode());
    }
}