package com.excusas.model.excusas;

import com.excusas.exceptions.ExcusaException;
import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import com.excusas.model.excusas.motivos.MotivoExcusa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExcusaTest {

    private Empleado empleado;
    private MotivoExcusa motivo;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        motivo = new MotivoTrivial();
    }

    @Test
    void deberiaCrearExcusaCorrectamente() {
        String descripcion = "Llegué tarde por el tráfico";

        Excusa excusa = new Excusa(empleado, motivo, descripcion);

        assertEquals(empleado, excusa.getEmpleado());
        assertEquals(motivo, excusa.getMotivo());
        assertEquals(descripcion, excusa.getDescripcion());
        assertEquals(empleado.getEmail(), excusa.getEmailEmpleado());
        assertEquals(empleado.getNombre(), excusa.getNombreEmpleado());
        assertEquals(empleado.getLegajo(), excusa.getLegajoEmpleado());
    }

    @Test
    void deberiaLanzarExcepcionCuandoEmpleadoEsNulo() {
        ExcusaException exception = assertThrows(ExcusaException.class, () -> {
            new Excusa(null, motivo, "Descripción válida");
        });

        assertEquals("El empleado no puede ser nulo", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoMotivoEsNulo() {
        ExcusaException exception = assertThrows(ExcusaException.class, () -> {
            new Excusa(empleado, null, "Descripción válida");
        });

        assertEquals("El motivo de la excusa no puede ser nulo", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoDescripcionEsNula() {
        ExcusaException exception = assertThrows(ExcusaException.class, () -> {
            new Excusa(empleado, motivo, null);
        });

        assertEquals("La descripción de la excusa no puede estar vacía", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoDescripcionEstaVacia() {
        ExcusaException exception = assertThrows(ExcusaException.class, () -> {
            new Excusa(empleado, motivo, "   ");
        });

        assertEquals("La descripción de la excusa no puede estar vacía", exception.getMessage());
    }
}

