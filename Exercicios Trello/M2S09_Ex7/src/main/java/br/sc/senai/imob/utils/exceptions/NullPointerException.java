package br.sc.senai.imob.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.sc.senai.imob.utils.exceptions.error.Error;

public class NullPointerException extends RuntimeException {
  private static final  String MESSAGE = "O campo deve ser preenchido.";

  private final transient Error error;
  
  public NullPointerException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public NullPointerException(String message, Exception exception) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, exception);
  }

  public NullPointerException(String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public NullPointerException(Exception exception) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, exception);
  }

  public Error getError() {
    return error;
  }
}