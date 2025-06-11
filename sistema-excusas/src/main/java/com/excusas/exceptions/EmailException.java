package com.excusas.exceptions;

public abstract class EmailException extends RuntimeException {

  public EmailException(String mensaje) {
    super(mensaje);
  }
}
