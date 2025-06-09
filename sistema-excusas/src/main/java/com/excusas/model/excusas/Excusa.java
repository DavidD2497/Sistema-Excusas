package com.excusas.model.excusas;

import com.excusas.model.excusas.interfaces.IExcusa;
import com.excusas.model.excusas.motivos.MotivoExcusa;
import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.interfaces.IEncargado;

public class Excusa implements IExcusa {

    private final Empleado empleado;
    private final MotivoExcusa motivo;
    private final String descripcion;

    public Excusa(Empleado empleado, MotivoExcusa motivo, String descripcion) {
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
}


