package com.excusas.model.excusas;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import com.excusas.model.excusas.motivos.MotivoModerado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ExcusaTest {

    private Empleado empleado;
    private MotivoTrivial motivoTrivial;
    private MotivoModerado motivoModerado;
    private Excusa excusaTrivial;
    private Excusa excusaModerada;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        motivoTrivial = new MotivoTrivial();
        motivoModerado = new MotivoModerado();
        excusaTrivial = new Excusa(empleado, motivoTrivial, "Me quedé dormido");
        excusaModerada = new Excusa(empleado, motivoModerado, "Se cortó la luz");
    }

    @Test
    void testCrearExcusa() {
        assertNotNull(excusaTrivial);
        assertEquals(empleado, excusaTrivial.getEmpleado());
        assertEquals(motivoTrivial, excusaTrivial.getMotivo());
        assertEquals("Me quedé dormido", excusaTrivial.getDescripcion());
    }

    @Test
    void testPuedeSerManejadaPorRecepcionista() {
        Recepcionista recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        assertTrue(excusaTrivial.puedeSerManejadaPor(recepcionista));
        assertFalse(excusaModerada.puedeSerManejadaPor(recepcionista));
    }

    @Test
    void testPuedeSerManejadaPorSupervisor() {
        SupervisorArea supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        assertFalse(excusaTrivial.puedeSerManejadaPor(supervisor));
        assertTrue(excusaModerada.puedeSerManejadaPor(supervisor));
    }
}
