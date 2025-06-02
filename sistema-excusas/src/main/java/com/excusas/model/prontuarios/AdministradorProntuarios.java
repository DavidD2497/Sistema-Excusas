package com.excusas.model.prontuarios;

import com.excusas.model.prontuarios.interfaces.IObservable;
import com.excusas.model.prontuarios.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class AdministradorProntuarios implements IObservable {

    private static AdministradorProntuarios instancia;
    private List<Prontuario> prontuarios;
    private List<IObserver> observadores;

    private AdministradorProntuarios() {
        this.prontuarios = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public static AdministradorProntuarios getInstance() {
        if (instancia == null) {
            instancia = new AdministradorProntuarios();
        }
        return instancia;
    }

    @Override
    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Prontuario prontuario) {
        for (IObserver observador : observadores) {
            observador.actualizar(prontuario);
        }
    }

    public void agregarProntuario(Prontuario prontuario) {
        prontuarios.add(prontuario);
        System.out.println("Prontuario agregado para empleado: " + prontuario.getEmpleado().getNombre());
        notificarObservadores(prontuario);
    }

    public List<Prontuario> getProntuarios() {
        return new ArrayList<>(prontuarios);
    }
}
