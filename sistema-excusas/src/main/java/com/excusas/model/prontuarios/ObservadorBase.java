package com.excusas.model.prontuarios;

import com.excusas.model.prontuarios.interfaces.IObserver;

public abstract class ObservadorBase implements IObserver {

    protected abstract void procesarActualizacion(Prontuario prontuario);

    @Override
    public final void actualizar(Prontuario prontuario) {
        this.procesarActualizacion(prontuario);
    }
}
