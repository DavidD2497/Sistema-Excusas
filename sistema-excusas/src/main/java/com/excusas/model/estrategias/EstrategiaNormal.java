package com.excusas.model.estrategias;

import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public class EstrategiaNormal extends EstrategiaManejo {

    @Override
    public void ejecutarEstrategia(Encargado encargado, Excusa excusa) {
        encargado.ejecutarProcesamiento(excusa);
    }
}

