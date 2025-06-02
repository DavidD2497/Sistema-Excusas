package com.excusas.model.empleados;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    private Empleado empleado;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
    }

    @Test
    void testCrearEmpleado() {
        assertNotNull(empleado);
        assertEquals("Juan Pérez", empleado.getNombre());
        assertEquals("juan@empresa.com", empleado.getEmail());
        assertEquals(1001, empleado.getLegajo());
    }

    @Test
    void testGetNombre() {
        assertEquals("Juan Pérez", empleado.getNombre());
    }

    @Test
    void testGetEmail() {
        assertEquals("juan@empresa.com", empleado.getEmail());
    }

    @Test
    void testGetLegajo() {
        assertEquals(1001, empleado.getLegajo());
    }
}

