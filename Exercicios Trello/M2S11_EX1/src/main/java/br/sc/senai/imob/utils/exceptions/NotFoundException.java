package br.sc.senai.imob.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.sc.senai.imob.utils.exceptions.error.Error;

public class NotFoundException extends RuntimeException {
  private static final  String MESSAGE = "Registro não encontrado.";

  private final transient Error error;
  
  public NotFoundException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public NotFoundException(String message, Exception exception) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, exception);
  }

  public NotFoundException(String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public NotFoundException(Exception exception, String locationField) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, exception, locationField);
  }

  public Error getError() {
    return error;
  }
}