package br.com.senai.heroi.utils.exceptions;

public class BusinessException extends RuntimeException {
  
  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }
}