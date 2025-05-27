package com.excusas.interfaces;

import com.excusas.model.excusas.Excusa;

public interface IEncargado {
    void setSiguiente(IEncargado siguiente);
    IEncargado getSiguiente();
    void setEstrategia(IEstrategiaManejo estrategia);  // ← Cambiar aquí
    void manejarExcusa(Excusa excusa);
    boolean puedeManejarla(Excusa excusa);
    void procesarExcusa(Excusa excusa);
}