package com.excusas.model.prontuarios;

import com.excusas.model.prontuarios.interfaces.IProntuario;
import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;

public class Prontuario implements IProntuario {

    private Empleado empleado;
    private Excusa excusa;
    private int legajo;

    public Prontuario(Empleado empleado, Excusa excusa, int legajo) {
        this.empleado = empleado;
        this.excusa = excusa;
        this.legajo = legajo;
    }

    @Override
    public Empleado getEmpleado() {
        return empleado;
    }

    @Override
    public Excusa getExcusa() {
        return excusa;
    }

    @Override
    public int getLegajo() {
        return legajo;
    }
}