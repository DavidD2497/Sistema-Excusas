package com.excusas.model.empleados.encargados;

import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.Encargado;

public class SupervisorArea extends Encargado {

    public SupervisorArea(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public boolean puedeManejarModerado() {
        return true;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Supervisor de Área procesando excusa moderada para: " + excusa.getEmpleado().getNombre());
        excusa.ejecutarAccionesEspecificas(this);
    }
}
