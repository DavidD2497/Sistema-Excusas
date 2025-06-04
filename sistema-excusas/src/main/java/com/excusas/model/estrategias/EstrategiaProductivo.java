package com.excusas.model.estrategias;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public class EstrategiaProductivo extends EstrategiaManejo {

    private final IEmailSender emailSender;

    public EstrategiaProductivo() {
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public void ejecutarEstrategia(Encargado encargado, Excusa excusa) {
        this.emailSender.enviarEmail(
                "cto@excusas.com",
                encargado.getEmail(),
                "Procesamiento productivo",
                "Procesando excusa de manera productiva para: " + excusa.getEmpleado().getNombre()
        );

        encargado.ejecutarProcesamiento(excusa);
    }
}