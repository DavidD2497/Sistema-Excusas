package com.excusas.model.prontuarios;

import com.excusas.model.prontuarios.interfaces.IObserver;

public class ObservadorBase implements IObserver {

    protected void procesarActualizacion(Prontuario prontuario) {
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        procesarActualizacion(prontuario);
    }
}
