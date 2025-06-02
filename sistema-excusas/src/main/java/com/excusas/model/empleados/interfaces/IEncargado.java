package com.excusas.model.empleados.interfaces;

import com.excusas.model.estrategias.interfaces.IEstrategiaManejo;
import com.excusas.model.excusas.Excusa;

public interface IEncargado {
    void setSiguiente(IEncargado siguiente);
    IEncargado getSiguiente();
    void setEstrategia(IEstrategiaManejo estrategia);
    void manejarExcusa(Excusa excusa);
    void procesarExcusa(Excusa excusa);

    boolean puedeManejarTrivial();
    boolean puedeManejarModerado();
    boolean puedeManejarComplejo();
    boolean puedeManejarInverosimil();
}