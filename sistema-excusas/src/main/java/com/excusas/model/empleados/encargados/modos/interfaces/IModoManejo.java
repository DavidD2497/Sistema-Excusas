package com.excusas.model.empleados.encargados.modos.interfaces;

import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;

public interface IModoManejo {
    void manejar(IEncargado encargado, Excusa excusa);
}
