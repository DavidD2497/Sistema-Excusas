package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.interfaces.IEncargado;

public abstract class MotivoModerado extends MotivoExcusa {

    @Override
    public final boolean esAceptablePor(IEncargado encargado) {
        return encargado.puedeManejarModerado();
    }

    @Override
    public abstract void ejecutarAccionesEspecificas(IEncargado encargado, String emailEmpleado);
}

