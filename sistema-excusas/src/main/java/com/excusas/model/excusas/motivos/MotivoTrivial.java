package com.excusas.model.excusas.motivos;

import com.excusas.interfaces.IEncargado;

public class MotivoTrivial extends MotivoExcusa {

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado.puedeManejarTrivial();
    }
}
