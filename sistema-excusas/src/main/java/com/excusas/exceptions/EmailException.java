package com.excusas.exceptions;

public class EmailException extends RuntimeException {

  public EmailException(String mensaje) {
    super(mensaje);
  }

  public EmailException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}

