package com.excusas.interfaces;

import com.excusas.model.prontuarios.Prontuario;

public interface IObservable {
    void agregarObservador(IObserver observador);
    void eliminarObservador(IObserver observador);
    void notificarObservadores(Prontuario prontuario);
    void agregarProntuario(Prontuario prontuario);
}