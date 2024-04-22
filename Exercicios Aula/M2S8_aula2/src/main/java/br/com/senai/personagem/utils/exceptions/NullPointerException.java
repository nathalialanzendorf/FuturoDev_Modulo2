package br.com.senai.personagem.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.senai.personagem.utils.exceptions.error.Error;

public class NullPointerException extends RuntimeException {

  private final Error error;
  private final static String MESSAGE = "O campo deve ser preenchido.";
  
  public NullPointerException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public NullPointerException(String message, Throwable cause) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, cause);
  }

  public NullPointerException(String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public NullPointerException(Throwable cause, String locationField) {
    super(MESSAGE, cause);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, cause, locationField);
  }

  public Error getError() {
    return error;
  }
}