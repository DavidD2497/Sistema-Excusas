package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.interfaces.IEncargado;

public class MotivoTrivial extends MotivoExcusa {

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado.puedeManejarTrivial();
    }
}

