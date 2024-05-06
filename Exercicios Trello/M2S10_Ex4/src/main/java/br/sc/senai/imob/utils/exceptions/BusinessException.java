package br.sc.senai.imob.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.sc.senai.imob.utils.exceptions.error.Error;

public class BusinessException extends RuntimeException {
  private static final  String MESSAGE = "Ocorreu um erro desconhecido.";

  private final transient Error error;
  
  public BusinessException() {
    super(MESSAGE);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE);
  }

  public BusinessException(String message, Exception exception) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, message, exception);
  }

  public BusinessException(String locationField) {
    super(MESSAGE);
    this.error = new Error(MESSAGE, locationField);
  }

  public BusinessException(Exception exception, String locationField) {
    super(MESSAGE, exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, MESSAGE, exception, locationField);
  }

  public BusinessException(Exception exception) {
    super(exception.getMessage(), exception);
    this.error = new Error(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
  }

  public Error getError() {
    return error;
  }
}