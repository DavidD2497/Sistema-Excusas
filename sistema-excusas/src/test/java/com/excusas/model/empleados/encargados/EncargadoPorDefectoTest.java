package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EncargadoPorDefectoTest {

    private EncargadoPorDefecto encargadoDefecto;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        encargadoDefecto = new EncargadoPorDefecto("Default Handler", "default@excusas.com", 2007);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Cualquier excusa");
    }

    @Test
    void testCrearEncargadoPorDefecto() {
        assertNotNull(encargadoDefecto);
        assertEquals("Default Handler", encargadoDefecto.getNombre());
        assertEquals("default@excusas.com", encargadoDefecto.getEmail());
        assertEquals(2007, encargadoDefecto.getLegajo());
    }

    @Test
    void testCapacidadesManejoExcusas() {
        assertFalse(encargadoDefecto.puedeManejarTrivial());
        assertFalse(encargadoDefecto.puedeManejarModerado());
        assertFalse(encargadoDefecto.puedeManejarComplejo());
        assertFalse(encargadoDefecto.puedeManejarInverosimil());
    }

    @Test
    void testProcesarExcusa() {
        assertDoesNotThrow(() -> encargadoDefecto.procesarExcusa(excusa));
    }

    @Test
    void testEjecutarProcesamiento() {
        assertDoesNotThrow(() -> encargadoDefecto.ejecutarProcesamiento(excusa));
    }
}

