package br.com.senai.heroi.utils.exceptions;

public class ConflictException extends RuntimeException {

  public ConflictException() {
    super();
  }

  public ConflictException(String message) {
    super(message);
  }
}