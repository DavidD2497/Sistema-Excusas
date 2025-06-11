package com.excusas.exceptions;

public abstract class EmpleadoException extends RuntimeException {

  public EmpleadoException(String mensaje) {
    super(mensaje);
  }
}
