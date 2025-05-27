package com.excusas.model.excusas.motivos;

import com.excusas.interfaces.IEncargado;
import com.excusas.model.encargados.SupervisorArea;

public class MotivoModerado extends MotivoExcusa {

    @Override
    public boolean validarEncargado(IEncargado encargado) {
        return encargado instanceof SupervisorArea;
    }

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado instanceof SupervisorArea;
    }
}
