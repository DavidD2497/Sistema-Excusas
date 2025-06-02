package com.excusas.model.empleados.encargados;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.Encargado;

public class Recepcionista extends Encargado {

    private IEmailSender emailSender;

    public Recepcionista(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public boolean puedeManejarTrivial() {
        return true;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Recepcionista procesando excusa trivial para: " + excusa.getEmpleado().getNombre());
        emailSender.enviarEmail(excusa.getEmpleado().getEmail(), this.getEmail(),
                "motivo demora", "la licencia fue aceptada");
    }
}