package br.com.senai.personagem.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.senai.personagem.utils.exceptions.error.Error;

public class InternalServerError extends RuntimeException {

  private final Error error;
  private final static String MESSAGE = "Ocorreu um erro desconhecido.";
  
  public InternalServerError() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGE);
  }

  public InternalServerError(String message, Throwable cause) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
  }

  public InternalServerError( String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public InternalServerError(Throwable cause, String locationField) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGE, cause, locationField);
  }

  public Error getError() {
    return error;
  }
}