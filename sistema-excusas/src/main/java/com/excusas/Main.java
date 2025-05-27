package com.excusas;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.encargados.*;
import com.excusas.model.estrategias.EstrategiaNormal;
import com.excusas.model.estrategias.EstrategiaProductivo;
import com.excusas.model.estrategias.EstrategiaVago;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoComplejo;
import com.excusas.model.excusas.motivos.MotivoInverosimil;
import com.excusas.model.excusas.motivos.MotivoModerado;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import com.excusas.model.prontuarios.AdministradorProntuarios;
import com.excusas.model.prontuarios.Prontuario;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE EXCUSAS S.A.\n");

        // ========== CREAR EMPLEADOS ==========
        Empleado empleado1 = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        Empleado empleado2 = new Empleado("María García", "maria@empresa.com", 1002);
        Empleado empleado3 = new Empleado("Carlos López", "carlos@empresa.com", 1003);
        Empleado empleado4 = new Empleado("Ana Martínez", "ana@empresa.com", 1004);
        Empleado empleado5 = new Empleado("Pedro Ruiz", "pedro@empresa.com", 1005);

        // ========== CREAR ENCARGADOS ==========
        Recepcionista recepcionista = new Recepcionista("Laura Recep", "laura@excusas.com", 2001);
        SupervisorArea supervisor = new SupervisorArea("Pedro Super", "pedro@excusas.com", 2002);
        GerenteRecursosHumanos gerente = new GerenteRecursosHumanos("Sofia Gerente", "sofia@excusas.com", 2003);
        CEO ceo1 = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
        CEO ceo2 = new CEO("Patricia CEO", "patricia@excusas.com", 2005);
        CEO ceo3 = new CEO("Carlos CEO", "carlos@excusas.com", 2006);
        EncargadoPorDefecto encargadoDefecto = new EncargadoPorDefecto("Default Handler", "default@excusas.com", 2007);

        // ========== CONFIGURAR CADENA DE RESPONSABILIDAD ==========
        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo1);
        ceo1.setSiguiente(encargadoDefecto);

        // ========== CONFIGURAR ESTRATEGIAS (PROBANDO TODAS) ==========
        recepcionista.setEstrategia(new EstrategiaNormal());
        supervisor.setEstrategia(new EstrategiaVago());
        gerente.setEstrategia(new EstrategiaProductivo());
        ceo1.setEstrategia(new EstrategiaNormal());
        encargadoDefecto.setEstrategia(new EstrategiaNormal());

        // AdministradorProntuarios notifica a todos los CEOs
        AdministradorProntuarios admin = AdministradorProntuarios.getInstance();
        admin.agregarObservador(ceo1);
        admin.agregarObservador(ceo2);
        admin.agregarObservador(ceo3);

        // ========== CREAR MOTIVOS Y EXCUSAS ==========
        MotivoTrivial motivoTrivial = new MotivoTrivial();
        MotivoModerado motivoModerado1 = new MotivoModerado();
        MotivoModerado motivoModerado2 = new MotivoModerado();
        MotivoComplejo motivoComplejo = new MotivoComplejo();
        MotivoInverosimil motivoInverosimil = new MotivoInverosimil();

        Excusa excusa1 = new Excusa(empleado1, motivoTrivial, "Me quedé dormido");
        Excusa excusa2 = new Excusa(empleado2, motivoModerado1, "Se cortó la luz en todo el barrio");
        Excusa excusa3 = new Excusa(empleado3, motivoModerado2, "Tuve que cuidar a mi familiar enfermo");
        Excusa excusa4 = new Excusa(empleado4, motivoComplejo, "Fui abducido por aliens");
        Excusa excusa5 = new Excusa(empleado5, motivoInverosimil, "Una paloma robó mi bicicleta y me persiguió por 3 cuadras");

        // ========== PROBAR TODOS LOS ESCENARIOS ==========

        System.out.println("1. EXCUSA TRIVIAL → Recepcionista (NORMAL):");
        System.out.println("Empleado: " + excusa1.getEmpleado().getNombre());
        System.out.println("Excusa: " + excusa1.getDescripcion());
        System.out.println("Esperado: Recepcionista la procesa directamente");
        recepcionista.manejarExcusa(excusa1);
        System.out.println("\n");

        System.out.println("2. EXCUSA MODERADA → Supervisor (VAGO) → Gerente (PRODUCTIVO):");
        System.out.println("Empleado: " + excusa2.getEmpleado().getNombre());
        System.out.println("Excusa: " + excusa2.getDescripcion());
        System.out.println("Esperado: Supervisor vago la pasa → Gerente productivo (No procesa excusas moderadas)");
        recepcionista.manejarExcusa(excusa2);
        System.out.println("\n");

        System.out.println("3. EXCUSA MODERADA (Familiar) → Supervisor (VAGO) → Gerente (PRODUCTIVO):");
        System.out.println("Empleado: " + excusa3.getEmpleado().getNombre());
        System.out.println("Excusa: " + excusa3.getDescripcion());
        System.out.println("Esperado: Supervisor vago la pasa → Gerente productivo (No procesa excusas moderadas)");
        recepcionista.manejarExcusa(excusa3);
        System.out.println("\n");

        System.out.println("4. EXCUSA COMPLEJA → Gerente (PRODUCTIVO):");
        System.out.println("Empleado: " + excusa4.getEmpleado().getNombre());
        System.out.println("Excusa: " + excusa4.getDescripcion());
        System.out.println("Esperado: Gerente productivo envía email al CTO y la procesa");
        recepcionista.manejarExcusa(excusa4);
        System.out.println("\n");

        System.out.println("5. EXCUSA INVEROSÍMIL → CEO (NORMAL):");
        System.out.println("Empleado: " + excusa5.getEmpleado().getNombre());
        System.out.println("Excusa: " + excusa5.getDescripcion());
        System.out.println("Esperado: CEO la procesa, crea prontuario y notifica a otros CEOs");
        recepcionista.manejarExcusa(excusa5);
        System.out.println("\n");

        // ========== MOSTRAR RESULTADOS ==========
        System.out.println("📋 PRONTUARIOS REGISTRADOS:");
        List<Prontuario> prontuarios = admin.getProntuarios();
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