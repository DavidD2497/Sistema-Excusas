package com.excusas.model.empleados.encargados;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;

public class EncargadoPorDefecto extends Encargado {

    private IEmailSender emailSender;

    public EncargadoPorDefecto(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public boolean puedeManejarla(Excusa excusa) {
        return true;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Excusa rechazada: necesitamos pruebas contundentes");
        emailSender.enviarEmail(excusa.getEmpleado().getEmail(), this.getEmail(),
                "Excusa rechazada", "Excusa rechazada: necesitamos pruebas contundentes");
    }
}
