package com.excusas.model.empleados;

import com.excusas.exceptions.EmpleadoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void deberiaCrearEmpleadoCorrectamente() {
        String nombre = "Juan Pérez";
        String email = "juan@empresa.com";
        int legajo = 1001;

        Empleado empleado = new Empleado(nombre, email, legajo);

        assertEquals(nombre, empleado.getNombre());
        assertEquals(email, empleado.getEmail());
        assertEquals(legajo, empleado.getLegajo());
    }

    @Test
    void deberiaLanzarExcepcionCuandoNombreEsNulo() {
        EmpleadoException exception = assertThrows(EmpleadoException.class, () -> {
            new Empleado(null, "juan@empresa.com", 1001);
        });

        assertEquals("El nombre del empleado no puede estar vacío", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoNombreEstaVacio() {
        EmpleadoException exception = assertThrows(EmpleadoException.class, () -> {
            new Empleado("   ", "juan@empresa.com", 1001);
        });

        assertEquals("El nombre del empleado no puede estar vacío", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoEmailEsNulo() {
        EmpleadoException exception = assertThrows(EmpleadoException.class, () -> {
            new Empleado("Juan Pérez", null, 1001);
        });

        assertEquals("El email del empleado no puede estar vacío", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoLegajoEsNegativo() {
        EmpleadoException exception = assertThrows(EmpleadoException.class, () -> {
            new Empleado("Juan Pérez", "juan@empresa.com", -1);
        });

        assertEquals("El legajo debe ser un número positivo", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoLegajoEsCero() {
        EmpleadoException exception = assertThrows(EmpleadoException.class, () -> {
            new Empleado("Juan Pérez", "juan@empresa.com", 0);
        });

        assertEquals("El legajo debe ser un número positivo", exception.getMessage());
    }
}

