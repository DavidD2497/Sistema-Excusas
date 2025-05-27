package com.excusas.model.excusas.motivos;

import com.excusas.interfaces.IEncargado;
import com.excusas.model.encargados.GerenteRecursosHumanos;

public class MotivoComplejo extends MotivoExcusa {

    @Override
    public boolean validarEncargado(IEncargado encargado) {
        return encargado instanceof GerenteRecursosHumanos;
    }

    @Override
    public boolean esAceptablePor(IEncargado encargado) {
        return encargado instanceof GerenteRecursosHumanos;
    }
}