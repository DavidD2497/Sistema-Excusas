package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecepcionistaTest {

    private Recepcionista recepcionista;
    private Empleado empleado;
    private Excusa excusaTrivial;

    @BeforeEach
    void setUp() {
        recepcionista = new Recepcionista("Laura Recep", "laura@excusas.com", 2001);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusaTrivial = new Excusa(empleado, new MotivoTrivial(), "Llegué tarde por el tráfico");
    }

    @Test
    void deberiaPoderManejarExcusasTriviales() {
        assertTrue(recepcionista.puedeManejarTrivial());
        assertFalse(recepcionista.puedeManejarModerado());
        assertFalse(recepcionista.puedeManejarComplejo());
        assertFalse(recepcionista.puedeManejarInverosimil());
    }
    @Test
    void deberiaProcesarExcusaTrivialCorrectamente() {
        assertDoesNotThrow(() -> {
            recepcionista.procesarExcusa(excusaTrivial);
        });
    }

    @Test
    void deberiaTenerDatosCorrectosDelEmpleado() {
        assertEquals("Laura Recep", recepcionista.getNombre());
        assertEquals("laura@excusas.com", recepcionista.getEmail());
        assertEquals(2001, recepcionista.getLegajo());
    }
}

