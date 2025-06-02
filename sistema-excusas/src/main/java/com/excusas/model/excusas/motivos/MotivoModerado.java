package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.interfaces.IEncargado;

public class MotivoModerado extends MotivoExcusa {

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado.puedeManejarModerado();
    }
}