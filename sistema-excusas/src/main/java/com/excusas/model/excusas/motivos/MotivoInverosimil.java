package com.excusas.model.excusas.motivos;

import com.excusas.interfaces.IEncargado;
import com.excusas.model.encargados.CEO;

public class MotivoInverosimil extends MotivoExcusa {

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado.puedeManejarInverosimil();  // ✅ Sin instanceof
    }
}