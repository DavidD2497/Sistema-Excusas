package com.excusas.interfaces;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.motivos.MotivoExcusa;

public interface IExcusa {
    Empleado getEmpleado();
    MotivoExcusa getMotivo();
    String getDescripcion();
}