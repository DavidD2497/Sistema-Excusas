package com.excusas.model.empleados.encargados;

import com.excusas.model.prontuarios.interfaces.IObserver;
import com.excusas.model.prontuarios.Prontuario;
import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.prontuarios.AdministradorProntuarios;

public class CEO extends Encargado implements IObserver {

    public CEO(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        AdministradorProntuarios.getInstance().agregarObservador(this);
    }

    @Override
    public boolean puedeManejarInverosimil() {
        return true;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("CEO procesando excusa extremadamente inverosímil para: " + excusa.getEmpleado().getNombre());

        IEmailSender emailSender = new EmailSenderConcreto();
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Respuesta CEO",
                "Aprobado por creatividad"
        );
        System.out.println("Respuesta: Aprobado por creatividad");

        AdministradorProntuarios.getInstance().notificarExcusaProcesada(excusa, this);
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        System.out.println("CEO " + this.getNombre() + " notificado sobre nuevo prontuario de: " +
                prontuario.getEmpleado().getNombre());
    }
}
