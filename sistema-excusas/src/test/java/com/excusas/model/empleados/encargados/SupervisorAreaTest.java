package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoProblemaFamiliar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SupervisorAreaTest {

    private SupervisorArea supervisor;
    private Empleado empleado;
    private Excusa excusaModerada;

    @BeforeEach
    void setUp() {
        supervisor = new SupervisorArea("Pedro Super", "pedro@excusas.com", 2002);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusaModerada = new Excusa(empleado, new MotivoProblemaFamiliar(), "Problema familiar urgente");
    }

    @Test
    void deberiaPoderManejarExcusasModeradas() {
        assertTrue(supervisor.puedeManejarModerado());
        assertFalse(supervisor.puedeManejarTrivial());
        assertFalse(supervisor.puedeManejarComplejo());
        assertFalse(supervisor.puedeManejarInverosimil());
    }

    @Test
    void deberiaProcesarExcusaModeradaCorrectamente() {
        assertDoesNotThrow(() -> {
            supervisor.procesarExcusa(excusaModerada);
        });
    }

    @Test
    void deberiaTenerDatosCorrectosDelEmpleado() {
        assertEquals("Pedro Super", supervisor.getNombre());
        assertEquals("pedro@excusas.com", supervisor.getEmail());
        assertEquals(2002, supervisor.getLegajo());
    }
}

