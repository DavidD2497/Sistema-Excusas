package com.excusas.exceptions;

public class ExcusaException extends RuntimeException {

  public ExcusaException(String mensaje) {
    super(mensaje);
  }

  public ExcusaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}