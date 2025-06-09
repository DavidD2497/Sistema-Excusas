package com.excusas.model.prontuarios;

import com.excusas.exceptions.ProntuarioException;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.prontuarios.interfaces.IObserver;
import java.util.ArrayList;
import java.util.List;

public class AdministradorProntuarios extends ObservableBase implements IObserver {

    private final List<Prontuario> prontuarios;

    private AdministradorProntuarios() {
        super();
        this.prontuarios = new ArrayList<>();
        this.agregarObservador(this);
    }

    private static class SingletonHolder {
        private static final AdministradorProntuarios INSTANCIA = new AdministradorProntuarios();
    }

    public static AdministradorProntuarios getInstance() {
        return SingletonHolder.INSTANCIA;
    }

    public void notificarExcusaProcesada(Excusa excusa, IEncargado encargadoProcesador) {
        if (this.debeCrearProntuario(excusa, encargadoProcesador)) {
            Prontuario prontuario = this.crearProntuario(excusa);
            this.agregarProntuario(prontuario);
        }
    }

    private boolean debeCrearProntuario(Excusa excusa, IEncargado encargadoProcesador) {
        return encargadoProcesador.puedeManejarInverosimil() &&
                excusa.getMotivo().esAceptablePor(encargadoProcesador);
    }

    private Prontuario crearProntuario(Excusa excusa) {
        return new Prontuario(
                excusa.getEmpleado(),
                excusa,
                excusa.getEmpleado().getLegajo()
        );
    }

    public void agregarProntuario(Prontuario prontuario) {
        if (prontuario == null) {
            throw new ProntuarioException("El prontuario no puede ser nulo");
        }
        if (prontuario.getEmpleado() == null) {
            throw new ProntuarioException("El empleado del prontuario no puede ser nulo");
        }

        this.prontuarios.add(prontuario);
        System.out.println("Prontuario creado para empleado: " + prontuario.getEmpleado().getNombre());

        this.notificarObservadores(prontuario);
    }

    public List<Prontuario> getProntuarios() {
        return new ArrayList<>(this.prontuarios);
    }

    public void limpiarProntuarios() {
        this.prontuarios.clear();
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        System.out.println("AdministradorProntuarios: Nuevo prontuario registrado para " +
                prontuario.getEmpleado().getNombre());
    }
}
