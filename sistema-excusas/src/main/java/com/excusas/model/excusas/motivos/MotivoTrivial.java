package com.excusas.model.excusas.motivos;

import com.excusas.interfaces.IEncargado;
import com.excusas.model.encargados.Recepcionista;

public class MotivoTrivial extends MotivoExcusa {

    @Override
    public boolean validarEncargado(IEncargado encargado) {
        return encargado instanceof Recepcionista;
    }

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado instanceof Recepcionista;
    }
}
