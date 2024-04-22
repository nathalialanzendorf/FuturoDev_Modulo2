package br.com.senai.task.utils.exceptions;

public class BusinessException extends RuntimeException {
  
  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }
  
}