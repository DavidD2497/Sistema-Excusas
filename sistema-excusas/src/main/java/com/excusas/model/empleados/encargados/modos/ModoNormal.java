package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;

public class ModoNormal extends ModoManejo {

    @Override
    public void ejecutarModo(IEncargado encargado, Excusa excusa) {
        encargado.ejecutarProcesamiento(excusa);
    }
}



