package com.excusas.model.empleados;

import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.empleados.encargados.modos.interfaces.IModoManejo;
import com.excusas.model.empleados.encargados.modos.ModoNormal;
import com.excusas.model.excusas.Excusa;

public abstract class Encargado extends Empleado implements IEncargado {

    private IEncargado siguiente;
    private IModoManejo modo;

    public Encargado(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.modo = new ModoNormal();
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
    public void setModo(IModoManejo modo) {
        this.modo = modo;
    }

    @Override
    public IModoManejo getModo() {
        return this.modo;
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        this.modo.manejar(this, excusa);
    }

    @Override
    public final void ejecutarProcesamiento(Excusa excusa) {
        if (excusa.puedeSerManejadaPor(this)) {
            this.preprocesarExcusa(excusa);
            this.procesarExcusa(excusa);
            this.postprocesarExcusa(excusa);
        } else if (this.getSiguiente() != null) {
            this.getSiguiente().manejarExcusa(excusa);
        } else {
            this.manejarExcusaNoManejable(excusa);
        }
    }

    protected void preprocesarExcusa(Excusa excusa) {
        System.out.println("Iniciando procesamiento de excusa para: " + excusa.getNombreEmpleado());
    }

    protected void postprocesarExcusa(Excusa excusa) {
        System.out.println("Finalizando procesamiento de excusa para: " + excusa.getNombreEmpleado());
    }

    protected void manejarExcusaNoManejable(Excusa excusa) {
        System.out.println("Excusa no pudo ser manejada por ningún encargado");
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
