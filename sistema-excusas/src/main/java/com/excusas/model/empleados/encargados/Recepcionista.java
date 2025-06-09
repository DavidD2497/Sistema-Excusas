package com.excusas.model.empleados.encargados;

import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.Encargado;

public class Recepcionista extends Encargado {

    public Recepcionista(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public boolean puedeManejarTrivial() {
        return true;
    }

    @Override
    protected void preprocesarExcusa(Excusa excusa) {
        super.preprocesarExcusa(excusa);
        System.out.println("Recepcionista verificando documentación básica...");
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Recepcionista procesando excusa trivial para: " + excusa.getNombreEmpleado());
        EmailSenderConcreto.getInstance().enviarEmail(
                excusa.getEmailEmpleado(),
                this.getEmail(),
                "motivo demora",
                "la licencia fue aceptada"
        );
    }

    @Override
    protected void postprocesarExcusa(Excusa excusa) {
        super.postprocesarExcusa(excusa);
        System.out.println("Recepcionista ha registrado la excusa en el sistema");
    }
}
