package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SupervisorAreaTest {

    private SupervisorArea supervisor;
    private Empleado empleado;

    @BeforeEach
    void setUp() {
        supervisor = new SupervisorArea("Pedro Super", "pedro@excusas.com", 2002);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
    }

    @Test
    void testCrearSupervisor() {
        assertNotNull(supervisor);
        assertEquals("Pedro Super", supervisor.getNombre());
        assertEquals("pedro@excusas.com", supervisor.getEmail());
        assertEquals(2002, supervisor.getLegajo());
    }

    @Test
    void testCapacidadesManejoExcusas() {
        assertFalse(supervisor.puedeManejarTrivial());
        assertTrue(supervisor.puedeManejarModerado());
        assertFalse(supervisor.puedeManejarComplejo());
        assertFalse(supervisor.puedeManejarInverosimil());
    }

    @Test
    void testProcesarExcusaProblemaFamiliar() {
        Excusa excusa = new Excusa(empleado, new MotivoProblemaFamiliar(), "Debo cuidar a mi familiar enfermo");
        assertDoesNotThrow(() -> supervisor.procesarExcusa(excusa));
    }

    @Test
    void testProcesarExcusaProblemaElectrico() {
        Excusa excusa = new Excusa(empleado, new MotivoProblemaElectrico(), "Se cortó la luz en mi zona");
        assertDoesNotThrow(() -> supervisor.procesarExcusa(excusa));
    }

    @Test
    void testManejarExcusaCompleta() {
        Excusa excusa = new Excusa(empleado, new MotivoProblemaFamiliar(), "Debo cuidar a mi familiar enfermo");
        assertDoesNotThrow(() -> supervisor.manejarExcusa(excusa));
    }
}

