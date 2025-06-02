package com.excusas.model.empleados.interfaces;

import com.excusas.model.excusas.Excusa;
import com.excusas.model.estrategias.interfaces.IEstrategiaManejo;

public interface IEncargado {
    void setSiguiente(IEncargado siguiente);
    IEncargado getSiguiente();
    void setEstrategia(IEstrategiaManejo estrategia);
    void manejarExcusa(Excusa excusa);
    void procesarExcusa(Excusa excusa);
    void ejecutarProcesamiento(Excusa excusa);

    boolean puedeManejarTrivial();
    boolean puedeManejarModerado();
    boolean puedeManejarComplejo();
    boolean puedeManejarInverosimil();
}