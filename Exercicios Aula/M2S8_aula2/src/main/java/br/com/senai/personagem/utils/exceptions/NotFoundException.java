package br.com.senai.personagem.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.senai.personagem.utils.exceptions.error.Error;

public class NotFoundException extends RuntimeException {

  private final Error error;
  private final static String MESSAGE = "Registro não encontrado.";
  
  public NotFoundException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public NotFoundException(String message, Throwable cause) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, cause);
  }

  public NotFoundException( String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public NotFoundException(Throwable cause, String locationField) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, cause, locationField);
  }

  public Error getError() {
    return error;
  }
}