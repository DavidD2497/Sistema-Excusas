package com.excusas.model.empleados.encargados;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.Encargado;

public class SupervisorArea extends Encargado {

    private IEmailSender emailSender;

    public SupervisorArea(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public boolean puedeManejarModerado() {
        return true;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Supervisor de Área procesando excusa moderada para: " + excusa.getEmpleado().getNombre());

        if (excusa.getDescripcion().toLowerCase().contains("luz") ||
                excusa.getDescripcion().toLowerCase().contains("corte")) {
            this.emailSender.enviarEmail("EDESUR@mailfake.com.ar", this.getEmail(),
                    "Consulta corte de luz", "Consulta si hubo corte de luz");
            System.out.println("Consultando a EDESUR sobre corte de luz");
        }

        if (excusa.getDescripcion().toLowerCase().contains("familiar") ||
                excusa.getDescripcion().toLowerCase().contains("cuidar")) {
            this.emailSender.enviarEmail(excusa.getEmpleado().getEmail(), this.getEmail(),
                    "Consulta familiar", "¿Todo está bien?");
            System.out.println("Preguntando al empleado si todo está bien con el familiar");
        }
    }
}