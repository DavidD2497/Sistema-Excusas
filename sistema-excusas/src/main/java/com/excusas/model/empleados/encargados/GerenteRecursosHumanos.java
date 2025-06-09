package com.excusas.model.empleados.encargados;

import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.Encargado;

public class GerenteRecursosHumanos extends Encargado {

    public GerenteRecursosHumanos(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public boolean puedeManejarComplejo() {
        return true;
    }

    @Override
    protected void preprocesarExcusa(Excusa excusa) {
        super.preprocesarExcusa(excusa);
        System.out.println("Gerente de RRHH revisando políticas de la empresa...");
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Gerente de RRHH procesando excusa compleja para: " + excusa.getNombreEmpleado());
        System.out.println("Excusa: " + excusa.getDescripcion());
    }

    @Override
    protected void postprocesarExcusa(Excusa excusa) {
        super.postprocesarExcusa(excusa);
        System.out.println("Gerente de RRHH ha documentado el caso para futuras referencias");
    }
}

