package com.excusas.interfaces;

import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public interface IEstrategiaManejo {
    void manejar(Encargado encargado, Excusa excusa);
}