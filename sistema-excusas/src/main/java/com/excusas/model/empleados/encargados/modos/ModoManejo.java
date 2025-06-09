package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.empleados.encargados.modos.interfaces.IModoManejo;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;

public abstract class ModoManejo implements IModoManejo {

    public abstract void ejecutarModo(IEncargado encargado, Excusa excusa);

    @Override
    public final void manejar(IEncargado encargado, Excusa excusa) {
        this.ejecutarModo(encargado, excusa);
    }
}


