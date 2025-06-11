package com.excusas.exceptions;

public class CadenaSinEncargadosException extends CadenaEncargadosException {

  public CadenaSinEncargadosException() {
    super("La cadena de encargados debe tener al menos un encargado");
  }
}

