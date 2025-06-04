package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoComplejo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class GerenteRecursosHumanosTest {

    private GerenteRecursosHumanos gerente;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        gerente = new GerenteRecursosHumanos("Sofia Gerente", "sofia@excusas.com", 2003);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoComplejo(), "Situación familiar compleja");
    }

    @Test
    void testCrearGerente() {
        assertNotNull(gerente);
        assertEquals("Sofia Gerente", gerente.getNombre());
        assertEquals("sofia@excusas.com", gerente.getEmail());
        assertEquals(2003, gerente.getLegajo());
    }

    @Test
    void testCapacidadesManejoExcusas() {
        assertFalse(gerente.puedeManejarTrivial());
        assertFalse(gerente.puedeManejarModerado());
        assertTrue(gerente.puedeManejarComplejo());
        assertFalse(gerente.puedeManejarInverosimil());
    }

    @Test
    void testProcesarExcusa() {
        assertDoesNotThrow(() -> gerente.procesarExcusa(excusa));
    }

    @Test
    void testManejarExcusa() {
        assertDoesNotThrow(() -> gerente.manejarExcusa(excusa));
    }
}
