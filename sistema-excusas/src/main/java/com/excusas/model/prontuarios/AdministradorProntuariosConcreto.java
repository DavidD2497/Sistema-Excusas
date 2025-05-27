package com.excusas.model.prontuarios;

import com.excusas.interfaces.IObservable;
import com.excusas.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class AdministradorProntuariosConcreto extends AdministradorProntuarios implements IObservable {

    private List<IObserver> observadores;

    public AdministradorProntuariosConcreto() {
        super();
        this.observadores = new ArrayList<>();
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

    @Override
    public void agregarProntuario(Prontuario prontuario) {
        super.agregarProntuario(prontuario);
        // Notifica a todos los CEOs cuando se agrega un nuevo prontuario
        notificarObservadores(prontuario);
    }
}