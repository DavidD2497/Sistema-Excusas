package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoComplejo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GerenteRecursosHumanosTest {

    private GerenteRecursosHumanos gerente;
    private Empleado empleado;
    private Excusa excusaCompleja;

    @BeforeEach
    void setUp() {
        gerente = new GerenteRecursosHumanos("Sofia Gerente", "sofia@excusas.com", 2003);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusaCompleja = new Excusa(empleado, new MotivoComplejo(), "Situación compleja que requiere análisis");
    }

    @Test
    void deberiaPoderManejarExcusasComplejas() {
        assertTrue(gerente.puedeManejarComplejo());
        assertFalse(gerente.puedeManejarTrivial());
        assertFalse(gerente.puedeManejarModerado());
        assertFalse(gerente.puedeManejarInverosimil());
    }

    @Test
    void deberiaProcesarExcusaComplejaCorrectamente() {
        assertDoesNotThrow(() -> {
            gerente.procesarExcusa(excusaCompleja);
        });
    }

    @Test
    void deberiaTenerDatosCorrectosDelEmpleado() {
        assertEquals("Sofia Gerente", gerente.getNombre());
        assertEquals("sofia@excusas.com", gerente.getEmail());
        assertEquals(2003, gerente.getLegajo());
    }
}


