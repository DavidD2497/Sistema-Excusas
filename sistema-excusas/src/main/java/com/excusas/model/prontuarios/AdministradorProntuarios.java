package com.excusas.model.prontuarios;

import com.excusas.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AdministradorProntuarios {

    private static AdministradorProntuariosConcreto instancia;
    protected List<Prontuario> prontuarios;

    protected AdministradorProntuarios() {
        this.prontuarios = new ArrayList<>();
    }

    public static AdministradorProntuariosConcreto getInstance() {
        if (instancia == null) {
            instancia = new AdministradorProntuariosConcreto();
        }
        return instancia;
    }

    public abstract void agregarObservador(IObserver observador);
    public abstract void eliminarObservador(IObserver observador);
    public abstract void notificarObservadores(Prontuario prontuario);

    public void agregarProntuario(Prontuario prontuario) {
        prontuarios.add(prontuario);
        System.out.println("Prontuario agregado para empleado: " + prontuario.getEmpleado().getNombre());
    }

    public List<Prontuario> getProntuarios() {
        return new ArrayList<>(prontuarios);
    }
}