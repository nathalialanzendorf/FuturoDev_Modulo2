package br.com.senai.task.utils.exceptions;

public class ConflictException extends RuntimeException {

  public ConflictException() {
    super();
  }

  public ConflictException(String message) {
    super(message);
  }
}