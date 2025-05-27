package com.excusas.model.estrategias;

import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public class EstrategiaNormal extends EstrategiaManejo {

    @Override
    public void ejecutarEstrategia(Encargado encargado, Excusa excusa) {
        if (encargado.puedeManejarla(excusa)) {
            encargado.procesarExcusa(excusa);
        } else if (encargado.getSiguiente() != null) {
            encargado.getSiguiente().manejarExcusa(excusa);
        }
    }
}
