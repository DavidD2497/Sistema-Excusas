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

    public boolean puedeManejarla(Excusa excusa) {
        return excusa.getMotivo().esAceptablePor(this);
    }

    @Override
    public abstract void procesarExcusa(Excusa excusa);
    
    @Override
    public boolean puedeManejarTrivial() { return false; }

    @Override
    public boolean puedeManejarModerado() { return false; }

    @Override
    public boolean puedeManejarComplejo() { return false; }

    @Override
    public boolean puedeManejarInverosimil() { return false; }
}
