package br.com.senai.personagem.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.senai.personagem.utils.exceptions.error.Error;

public class BusinessException extends RuntimeException {

  private final Error error;
  private final static String MESSAGE = "Ocorreu um erro desconhecido.";
  
  public BusinessException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public BusinessException(String message, Throwable cause) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, cause);
  }

  public BusinessException( String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public BusinessException(Throwable cause, String locationField) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, cause, locationField);
  }

  public Error getError() {
    return error;
  }
}