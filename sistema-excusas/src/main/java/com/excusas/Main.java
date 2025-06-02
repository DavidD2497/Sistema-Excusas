package com.excusas;

import com.excusas.config.ConfiguradorSistema;
import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.*;
import com.excusas.model.prontuarios.AdministradorProntuarios;
import com.excusas.model.prontuarios.Prontuario;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE EXCUSAS S.A.\n");

        ConfiguradorSistema configurador = new ConfiguradorSistema();

        Empleado empleado1 = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        Empleado empleado2 = new Empleado("María García", "maria@empresa.com", 1002);
        Empleado empleado3 = new Empleado("Carlos López", "carlos@empresa.com", 1003);
        Empleado empleado4 = new Empleado("Ana Martínez", "ana@empresa.com", 1004);
        Empleado empleado5 = new Empleado("Pedro Ruiz", "pedro@empresa.com", 1005);

        Excusa excusa1 = new Excusa(empleado1, new MotivoTrivial(), "Me quedé dormido");
        Excusa excusa2 = new Excusa(empleado2, new MotivoModerado(), "Se cortó la luz en todo el barrio");
        Excusa excusa3 = new Excusa(empleado3, new MotivoModerado(), "Tuve que cuidar a mi familiar enfermo");
        Excusa excusa4 = new Excusa(empleado4, new MotivoComplejo(), "Fui abducido por aliens");
        Excusa excusa5 = new Excusa(empleado5, new MotivoInverosimil(), "Una paloma robó mi bicicleta y me persiguió por 3 cuadras");

        System.out.println("=== PROCESANDO EXCUSAS ===\n");

        procesarExcusa("EXCUSA TRIVIAL", excusa1, configurador);
        procesarExcusa("EXCUSA MODERADA (Corte de luz)", excusa2, configurador);
        procesarExcusa("EXCUSA MODERADA (Familiar)", excusa3, configurador);
        procesarExcusa("EXCUSA COMPLEJA", excusa4, configurador);
        procesarExcusa("EXCUSA INVEROSÍMIL", excusa5, configurador);
        mostrarProntuarios();
    }

    private static void procesarExcusa(String tipo, Excusa excusa, ConfiguradorSistema configurador) {
        System.out.println("=== " + tipo + " ===");
        System.out.println("Empleado: " + excusa.getEmpleado().getNombre());
        System.out.println("Excusa: " + excusa.getDescripcion());
        configurador.getRecepcionista().manejarExcusa(excusa);
        System.out.println();
    }

    private static void mostrarProntuarios() {
        System.out.println("📋 PRONTUARIOS REGISTRADOS:");
        List<Prontuario> prontuarios = AdministradorProntuarios.getInstance().getProntuarios();
        if (prontuarios.isEmpty()) {
            System.out.println("No hay prontuarios registrados.");
        } else {
            for (int i = 0; i < prontuarios.size(); i++) {
                Prontuario p = prontuarios.get(i);
                System.out.println((i + 1) + ". Empleado: " + p.getEmpleado().getNombre() +
                        " | Legajo: " + p.getLegajo() +
                        " | Excusa: " + p.getExcusa().getDescripcion());
            }
        }
    }
}
