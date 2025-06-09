package com.excusas.model.excusas;

import com.excusas.exceptions.ExcusaException;
import com.excusas.model.excusas.interfaces.IExcusa;
import com.excusas.model.excusas.motivos.MotivoExcusa;
import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.interfaces.IEncargado;

public class Excusa implements IExcusa {

    private final Empleado empleado;
    private final MotivoExcusa motivo;
    private final String descripcion;

    public Excusa(Empleado empleado, MotivoExcusa motivo, String descripcion) {
        if (empleado == null) {
            throw new ExcusaException("El empleado no puede ser nulo");
        }
        if (motivo == null) {
            throw new ExcusaException("El motivo de la excusa no puede ser nulo");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new ExcusaException("La descripción de la excusa no puede estar vacía");
        }

        this.empleado = empleado;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    @Override
    public Empleado getEmpleado() {
        return this.empleado;
    }

    @Override
    public MotivoExcusa getMotivo() {
        return this.motivo;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public boolean puedeSerManejadaPor(IEncargado encargado) {
        return this.motivo.esAceptablePor(encargado);
    }

    public String getEmailEmpleado() {
        return this.empleado.getEmail();
    }

    public String getNombreEmpleado() {
        return this.empleado.getNombre();
    }

    public int getLegajoEmpleado() {
        return this.empleado.getLegajo();
    }

    public void ejecutarAccionesEspecificas(IEncargado encargado) {
        this.motivo.ejecutarAccionesEspecificas(encargado, this.empleado.getEmail());
    }
}
