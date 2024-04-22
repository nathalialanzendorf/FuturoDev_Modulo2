package br.com.senai.personagem.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.senai.personagem.utils.exceptions.error.Error;

public class ConflictException extends RuntimeException {

  private final Error error;
  private final static String MESSAGE = "O registro já existe.";
  
  public ConflictException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public ConflictException(String message, Throwable cause) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, cause);
  }

  public ConflictException( String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public ConflictException(Throwable cause, String locationField) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, cause, locationField);
  }

  public Error getError() {
    return error;
  }
}