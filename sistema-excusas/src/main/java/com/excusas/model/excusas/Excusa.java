package com.excusas.model.excusas;

import com.excusas.interfaces.IExcusa;
import com.excusas.model.excusas.motivos.MotivoExcusa;
import com.excusas.model.empleados.Empleado;

public class Excusa implements IExcusa {

    private Empleado empleado;
    private MotivoExcusa motivo;
    private String descripcion;

    public Excusa(Empleado empleado, MotivoExcusa motivo, String descripcion) {
        this.empleado = empleado;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    @Override
    public Empleado getEmpleado() {
        return empleado;
    }

    @Override
    public MotivoExcusa getMotivo() {
        return motivo;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}