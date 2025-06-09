package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;

public class ModoProductivo extends ModoManejo {

    @Override
    public void ejecutarModo(IEncargado encargado, Excusa excusa) {
        IEmailSender emailSender = new EmailSenderConcreto();
        emailSender.enviarEmail(
                "cto@excusas.com",
                encargado.getEmail(),
                "Procesamiento productivo",
                "Procesando excusa de manera productiva para: " + excusa.getEmpleado().getNombre()
        );
        encargado.ejecutarProcesamiento(excusa);
    }
}
