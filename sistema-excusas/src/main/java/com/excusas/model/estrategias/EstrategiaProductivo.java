package com.excusas.model.estrategias;

import com.excusas.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public class EstrategiaProductivo extends EstrategiaManejo {

    private IEmailSender emailSender;

    public EstrategiaProductivo() {
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public void ejecutarEstrategia(Encargado encargado, Excusa excusa) {

        emailSender.enviarEmail("cto@excusas.com", encargado.getEmail(),
                "Procesamiento productivo",
                "Procesando excusa de manera productiva para: " + excusa.getEmpleado().getNombre());

        if (encargado.puedeManejarla(excusa)) {
            encargado.procesarExcusa(excusa);
        } else if (encargado.getSiguiente() != null) {
            encargado.getSiguiente().manejarExcusa(excusa);
        }
    }
}