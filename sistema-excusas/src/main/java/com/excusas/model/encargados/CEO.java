package com.excusas.model.encargados;

import com.excusas.interfaces.IObservable;
import com.excusas.interfaces.IObserver;
import com.excusas.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.Encargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.prontuarios.AdministradorProntuarios;
import com.excusas.model.prontuarios.Prontuario;

import java.util.ArrayList;
import java.util.List;

public class CEO extends Encargado implements IObservable, IObserver {

    private List<IObserver> observadores;
    private IEmailSender emailSender;

    public CEO(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.observadores = new ArrayList<>();
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public boolean puedeManejarInverosimil() {
        return true;  // ✅ CEO maneja inverosímiles
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("CEO procesando excusa inverosímil para: " + excusa.getEmpleado().getNombre());

        emailSender.enviarEmail(excusa.getEmpleado().getEmail(), this.getEmail(),
                "Respuesta CEO", "Aprobado por creatividad");
        System.out.println("Respuesta: Aprobado por creatividad");

        Prontuario prontuario = new Prontuario(excusa.getEmpleado(), excusa, excusa.getEmpleado().getLegajo());
        procesarActualizacion(prontuario);

        notificarObservadores(prontuario);
    }

    public void procesarActualizacion(Prontuario prontuario) {
        AdministradorProntuarios.getInstance().agregarProntuario(prontuario);
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        System.out.println("🔔 CEO " + this.getNombre() + " notificado sobre nuevo prontuario de: " +
                prontuario.getEmpleado().getNombre());
    }

    @Override
    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Prontuario prontuario) {
        for (IObserver observador : observadores) {
            observador.actualizar(prontuario);
        }
    }
}