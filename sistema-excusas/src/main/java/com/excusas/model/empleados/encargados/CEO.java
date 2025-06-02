package com.excusas.model.empleados.encargados;

import com.excusas.model.prontuarios.interfaces.IObserver;
import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.prontuarios.AdministradorProntuarios;
import com.excusas.model.prontuarios.Prontuario;

public class CEO extends Encargado implements IObserver {

    private IEmailSender emailSender;

    public CEO(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public boolean puedeManejarInverosimil() {
        return true;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("CEO procesando excusa inverosímil para: " + excusa.getEmpleado().getNombre());

        this.emailSender.enviarEmail(excusa.getEmpleado().getEmail(), this.getEmail(),
                "Respuesta CEO", "Aprobado por creatividad");
        System.out.println("Respuesta: Aprobado por creatividad");

        Prontuario prontuario = new Prontuario(excusa.getEmpleado(), excusa, excusa.getEmpleado().getLegajo());
        this.procesarActualizacion(prontuario);
    }

    public void procesarActualizacion(Prontuario prontuario) {
        AdministradorProntuarios.getInstance().agregarProntuario(prontuario);
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        System.out.println("-CEO " + this.getNombre() + " notificado sobre nuevo prontuario de: " +
                prontuario.getEmpleado().getNombre());
    }
}

