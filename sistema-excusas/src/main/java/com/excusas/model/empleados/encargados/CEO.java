package com.excusas.model.empleados.encargados;

import com.excusas.model.prontuarios.interfaces.IObserver;
import com.excusas.model.prontuarios.Prontuario;
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
    protected void preprocesarExcusa(Excusa excusa) {
        super.preprocesarExcusa(excusa);
        System.out.println("CEO evaluando excusa extremadamente inverosímil...");
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("CEO procesando excusa extremadamente inverosímil para: " + excusa.getNombreEmpleado());

        EmailSenderConcreto.getInstance().enviarEmail(
                excusa.getEmailEmpleado(),
                this.getEmail(),
                "Respuesta CEO",
                "Aprobado por creatividad"
        );
        System.out.println("Respuesta: Aprobado por creatividad");
    }

    @Override
    protected void postprocesarExcusa(Excusa excusa) {
        super.postprocesarExcusa(excusa);
        AdministradorProntuarios.getInstance().notificarExcusaProcesada(excusa, this);
        System.out.println("CEO ha completado el procesamiento y notificado al administrador de prontuarios");
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        System.out.println("CEO " + this.getNombre() + " notificado sobre nuevo prontuario de: " +
                prontuario.getEmpleado().getNombre());
    }
}
