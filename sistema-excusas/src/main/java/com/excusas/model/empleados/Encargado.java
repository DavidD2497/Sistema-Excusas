package com.excusas.model.empleados;

import com.excusas.interfaces.IEncargado;
import com.excusas.interfaces.IEstrategiaManejo;
import com.excusas.model.excusas.Excusa;

public abstract class Encargado extends Empleado implements IEncargado {

    private IEncargado siguiente;
    private IEstrategiaManejo estrategia;

    public Encargado(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public void setSiguiente(IEncargado siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public IEncargado getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setEstrategia(IEstrategiaManejo estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        estrategia.manejar(this, excusa);
    }

    @Override
    public abstract boolean puedeManejarla(Excusa excusa);

    @Override
    public abstract void procesarExcusa(Excusa excusa);
}
