package com.excusas.model.prontuarios;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoInverosimil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ProntuarioTest {

    private Prontuario prontuario;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoInverosimil(), "Fui abducido por aliens");
        prontuario = new Prontuario(empleado, excusa, 1001);
    }

    @Test
    void testCrearProntuario() {
        assertNotNull(prontuario);
        assertEquals(empleado, prontuario.getEmpleado());
        assertEquals(excusa, prontuario.getExcusa());
        assertEquals(1001, prontuario.getLegajo());
    }

    @Test
    void testGetEmpleado() {
        assertEquals(empleado, prontuario.getEmpleado());
    }

    @Test
    void testGetExcusa() {
        assertEquals(excusa, prontuario.getExcusa());
    }

    @Test
    void testGetLegajo() {
        assertEquals(1001, prontuario.getLegajo());
    }

    @Test
    void testProntuarioConLegajoDiferente() {
        Prontuario prontuarioDiferente = new Prontuario(empleado, excusa, 9999);
        assertEquals(9999, prontuarioDiferente.getLegajo());
        assertNotEquals(empleado.getLegajo(), prontuarioDiferente.getLegajo());
    }
}

