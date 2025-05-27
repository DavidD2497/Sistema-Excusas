package com.excusas.model.excusas.motivos;

import com.excusas.interfaces.IEncargado;

public abstract class MotivoExcusa {

    public abstract boolean esAceptablePor(IEncargado encargado);
}
