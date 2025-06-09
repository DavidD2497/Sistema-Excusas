package com.excusas.exceptions;

public class EmpleadoException extends RuntimeException {

  public EmpleadoException(String mensaje) {
    super(mensaje);
  }

  public EmpleadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}