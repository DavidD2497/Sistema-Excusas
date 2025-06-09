package com.excusas.exceptions;

public class ProntuarioException extends RuntimeException {

    public ProntuarioException(String mensaje) {
        super(mensaje);
    }

    public ProntuarioException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

