package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class RecepcionistaTest {

    private Recepcionista recepcionista;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        recepcionista = new Recepcionista("Laura Recep", "laura@excusas.com", 2001);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Me quedé dormido");
    }

    @Test
    void testCrearRecepcionista() {
        assertNotNull(recepcionista);
        assertEquals("Laura Recep", recepcionista.getNombre());
        assertEquals("laura@excusas.com", recepcionista.getEmail());
        assertEquals(2001, recepcionista.getLegajo());
    }

    @Test
    void testCapacidadesManejoExcusas() {
        assertTrue(recepcionista.puedeManejarTrivial());
        assertFalse(recepcionista.puedeManejarModerado());
        assertFalse(recepcionista.puedeManejarComplejo());
        assertFalse(recepcionista.puedeManejarInverosimil());
    }

    @Test
    void testProcesarExcusa() {
        assertDoesNotThrow(() -> recepcionista.procesarExcusa(excusa));
    }

    @Test
    void testManejarExcusa() {
        assertDoesNotThrow(() -> recepcionista.manejarExcusa(excusa));
    }

    @Test
    void testEstrategiaInicial() {
        assertNotNull(recepcionista.getEstrategia());
    }
}

