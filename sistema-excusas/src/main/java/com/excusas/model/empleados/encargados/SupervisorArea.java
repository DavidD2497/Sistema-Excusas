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
    protected void preprocesarExcusa(Excusa excusa) {
        super.preprocesarExcusa(excusa);
        System.out.println("Supervisor de Área verificando detalles de la excusa moderada...");
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Supervisor de Área procesando excusa moderada para: " + excusa.getNombreEmpleado());
        excusa.ejecutarAccionesEspecificas(this);
    }

    @Override
    protected void postprocesarExcusa(Excusa excusa) {
        super.postprocesarExcusa(excusa);
        System.out.println("Supervisor de Área ha completado la verificación de la excusa");
    }
}

