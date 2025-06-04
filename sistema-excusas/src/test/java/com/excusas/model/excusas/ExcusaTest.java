package com.excusas.model.excusas;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.empleados.encargados.GerenteRecursosHumanos;
import com.excusas.model.empleados.encargados.CEO;
import com.excusas.model.excusas.motivos.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ExcusaTest {

    private Empleado empleado;
    private MotivoTrivial motivoTrivial;
    private MotivoProblemaFamiliar motivoProblemaFamiliar;
    private MotivoProblemaElectrico motivoProblemaElectrico;
    private MotivoComplejo motivoComplejo;
    private MotivoInverosimil motivoInverosimil;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        motivoTrivial = new MotivoTrivial();
        motivoProblemaFamiliar = new MotivoProblemaFamiliar();
        motivoProblemaElectrico = new MotivoProblemaElectrico();
        motivoComplejo = new MotivoComplejo();
        motivoInverosimil = new MotivoInverosimil();
    }

    @Test
    void testCrearExcusa() {
        Excusa excusa = new Excusa(empleado, motivoTrivial, "Me quedé dormido");

        assertNotNull(excusa);
        assertEquals(empleado, excusa.getEmpleado());
        assertEquals(motivoTrivial, excusa.getMotivo());
        assertEquals("Me quedé dormido", excusa.getDescripcion());
    }

    @Test
    void testPuedeSerManejadaPorRecepcionista() {
        Recepcionista recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);

        Excusa excusaTrivial = new Excusa(empleado, motivoTrivial, "Me quedé dormido");
        Excusa excusaProblemaFamiliar = new Excusa(empleado, motivoProblemaFamiliar, "Problema familiar");

        assertTrue(excusaTrivial.puedeSerManejadaPor(recepcionista));
        assertFalse(excusaProblemaFamiliar.puedeSerManejadaPor(recepcionista));
    }

    @Test
    void testPuedeSerManejadaPorSupervisor() {
        SupervisorArea supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);

        Excusa excusaTrivial = new Excusa(empleado, motivoTrivial, "Me quedé dormido");
        Excusa excusaProblemaFamiliar = new Excusa(empleado, motivoProblemaFamiliar, "Problema familiar");
        Excusa excusaCompleja = new Excusa(empleado, motivoComplejo, "Situación compleja");

        assertFalse(excusaTrivial.puedeSerManejadaPor(supervisor));
        assertTrue(excusaProblemaFamiliar.puedeSerManejadaPor(supervisor));
        assertFalse(excusaCompleja.puedeSerManejadaPor(supervisor));
    }

    @Test
    void testPuedeSerManejadaPorGerente() {
        GerenteRecursosHumanos gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);

        Excusa excusaCompleja = new Excusa(empleado, motivoComplejo, "Situación compleja");
        Excusa excusaInverosimil = new Excusa(empleado, motivoInverosimil, "Abducción alien");

        assertTrue(excusaCompleja.puedeSerManejadaPor(gerente));
        assertFalse(excusaInverosimil.puedeSerManejadaPor(gerente));
    }

    @Test
    void testPuedeSerManejadaPorCEO() {
        CEO ceo = new CEO("Roberto", "roberto@excusas.com", 2004);

        Excusa excusaInverosimil = new Excusa(empleado, motivoInverosimil, "Abducción alien");
        Excusa excusaTrivial = new Excusa(empleado, motivoTrivial, "Me quedé dormido");

        assertTrue(excusaInverosimil.puedeSerManejadaPor(ceo));
        assertFalse(excusaTrivial.puedeSerManejadaPor(ceo));
    }

    @Test
    void testEjecutarAccionesEspecificas() {
        SupervisorArea supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);

        Excusa excusaProblemaFamiliar = new Excusa(empleado, motivoProblemaFamiliar, "Problema familiar");
        Excusa excusaProblemaElectrico = new Excusa(empleado, motivoProblemaElectrico, "Corte de luz");

        assertDoesNotThrow(() -> excusaProblemaFamiliar.ejecutarAccionesEspecificas(supervisor));
        assertDoesNotThrow(() -> excusaProblemaElectrico.ejecutarAccionesEspecificas(supervisor));
    }
}

