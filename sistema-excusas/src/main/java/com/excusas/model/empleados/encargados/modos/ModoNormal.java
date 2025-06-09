package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.encargados.modos.interfaces.IModoManejo;

public class ModoNormal implements IModoManejo {

    @Override
    public void manejar(IEncargado encargado, Excusa excusa) {
        encargado.ejecutarProcesamiento(excusa);
    }
}



