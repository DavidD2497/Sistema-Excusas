package com.excusas.exceptions;

public abstract class ExcusaException extends RuntimeException {

  public ExcusaException(String mensaje) {
    super(mensaje);
  }
}
