package com.excusas.model.empleados;

import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.estrategias.interfaces.IEstrategiaManejo;
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
        this.estrategia.manejar(this, excusa);
    }

    @Override
    public void ejecutarProcesamiento(Excusa excusa) {
        if (excusa.puedeSerManejadaPor(this)) {
            this.procesarExcusa(excusa);
        } else if (this.getSiguiente() != null) {
            this.getSiguiente().manejarExcusa(excusa);
        }
    }

    @Override
    public abstract void procesarExcusa(Excusa excusa);

    @Override
    public boolean puedeManejarTrivial() {
        return false;
    }

    @Override
    public boolean puedeManejarModerado() {
        return false;
    }

    @Override
    public boolean puedeManejarComplejo() {
        return false;
    }

    @Override
    public boolean puedeManejarInverosimil() {
        return false;
    }
}

