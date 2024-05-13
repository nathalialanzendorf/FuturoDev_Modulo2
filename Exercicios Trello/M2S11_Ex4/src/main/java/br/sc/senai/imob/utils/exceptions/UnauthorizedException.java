package br.sc.senai.imob.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.sc.senai.imob.utils.exceptions.error.Error;

public class UnauthorizedException extends RuntimeException {
  private static final  String MESSAGE = "Acesso nao autorizado";

  private final transient Error error;
  
  public UnauthorizedException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.UNAUTHORIZED, MESSAGE);
  }

  public UnauthorizedException(String message, Exception exception) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.UNAUTHORIZED, message, exception);
  }

  public UnauthorizedException(String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public UnauthorizedException(Exception exception, String locationField) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.UNAUTHORIZED, MESSAGE, exception, locationField);
  }

  public UnauthorizedException(Exception exception) {
    super(exception.getMessage(), exception);
    this.error = new Error(HttpStatus.UNAUTHORIZED, exception.getMessage(), exception);
  }

  public Error getError() {
    return error;
  }
}