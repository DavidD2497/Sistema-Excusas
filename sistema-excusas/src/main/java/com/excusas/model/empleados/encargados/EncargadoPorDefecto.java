package com.excusas.model.empleados.encargados;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.empleados.encargados.modos.interfaces.IModoManejo;
import com.excusas.model.empleados.encargados.modos.ModoNormal;
import com.excusas.model.excusas.Excusa;

public class EncargadoPorDefecto implements IEncargado {

    private final String nombre;
    private final String email;
    private final int legajo;
    private IEncargado siguiente;
    private IModoManejo modo;

    public EncargadoPorDefecto(String nombre, String email, int legajo) {
        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
        this.modo = new ModoNormal();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public int getLegajo() {
        return this.legajo;
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
    public void ejecutarProcesamiento(Excusa excusa) {
        this.procesarExcusa(excusa);
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Excusa rechazada: necesitamos pruebas contundentes");

        IEmailSender emailSender = new EmailSenderConcreto();
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Excusa rechazada",
                "Excusa rechazada: necesitamos pruebas contundentes"
        );
    }

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
