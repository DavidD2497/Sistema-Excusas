package com.excusas.model.prontuarios;

import com.excusas.model.prontuarios.interfaces.IObservable;
import com.excusas.model.prontuarios.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class AdministradorProntuarios implements IObservable {

    private static AdministradorProntuarios instancia;
    private final List<Prontuario> prontuarios;
    private final List<IObserver> observadores;

    private AdministradorProntuarios() {
        this.prontuarios = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public static synchronized AdministradorProntuarios getInstance() {
        if (instancia == null) {
            instancia = new AdministradorProntuarios();
        }
        return instancia;
    }

    @Override
    public void agregarObservador(IObserver observador) {
        this.observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Prontuario prontuario) {
        List<IObserver> observadoresCopia = new ArrayList<>(this.observadores);
        for (IObserver observador : observadoresCopia) {
            observador.actualizar(prontuario);
        }
    }

    @Override
    public void agregarProntuario(Prontuario prontuario) {
        this.prontuarios.add(prontuario);
        System.out.println("Prontuario agregado para empleado: " + prontuario.getEmpleado().getNombre());
        this.notificarObservadores(prontuario);
    }

    public List<Prontuario> getProntuarios() {
        return new ArrayList<>(this.prontuarios);
    }

    // Método para limpiar prontuarios (útil para tests)
    public void limpiarProntuarios() {
        this.prontuarios.clear();
    }
}


