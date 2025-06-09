package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.encargados.modos.interfaces.IModoManejo;

public class ModoProductivo implements IModoManejo {

    @Override
    public void manejar(IEncargado encargado, Excusa excusa) {
        EmailSenderConcreto.getInstance().enviarEmail(
                "cto@excusas.com",
                encargado.getEmail(),
                "Procesamiento productivo",
                "Procesando excusa de manera productiva para: " + excusa.getEmpleado().getNombre()
        );
        encargado.ejecutarProcesamiento(excusa);
    }
}

