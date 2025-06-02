package com.excusas.model.estrategias;

import com.excusas.model.estrategias.interfaces.IEstrategiaManejo;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public abstract class EstrategiaManejo implements IEstrategiaManejo {

    public abstract void ejecutarEstrategia(Encargado encargado, Excusa excusa);

    @Override
    public void manejar(Encargado encargado, Excusa excusa) {
        ejecutarEstrategia(encargado, excusa);
    }
}

