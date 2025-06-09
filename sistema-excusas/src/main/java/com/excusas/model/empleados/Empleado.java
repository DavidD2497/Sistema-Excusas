package com.excusas.model.empleados;

import com.excusas.exceptions.EmpleadoException;
import com.excusas.model.empleados.interfaces.IEmpleado;

public class Empleado implements IEmpleado {

    private final String nombre;
    private final String email;
    private final int legajo;

    public Empleado(String nombre, String email, int legajo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EmpleadoException("El nombre del empleado no puede estar vacío");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new EmpleadoException("El email del empleado no puede estar vacío");
        }
        if (legajo <= 0) {
            throw new EmpleadoException("El legajo debe ser un número positivo");
        }

        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public int getLegajo() {
        return this.legajo;
    }
}
