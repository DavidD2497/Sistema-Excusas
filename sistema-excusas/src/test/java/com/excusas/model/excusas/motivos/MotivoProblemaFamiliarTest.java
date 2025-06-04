package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoProblemaFamiliarTest {

    private MotivoProblemaFamiliar motivoProblemaFamiliar;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoProblemaFamiliar = new MotivoProblemaFamiliar();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testHerencia() {
        assertTrue(motivoProblemaFamiliar instanceof MotivoModerado);
        assertTrue(motivoProblemaFamiliar instanceof MotivoExcusa);
    }

    @Test
    void testEsAceptablePorSupervisor() {
        assertTrue(motivoProblemaFamiliar.esAceptablePor(supervisor));
    }

    @Test
    void testNoEsAceptablePorOtrosEncargados() {
        assertFalse(motivoProblemaFamiliar.esAceptablePor(recepcionista));
        assertFalse(motivoProblemaFamiliar.esAceptablePor(gerente));
        assertFalse(motivoProblemaFamiliar.esAceptablePor(ceo));
    }

    @Test
    void testEjecutarAccionesEspecificas() {
        assertDoesNotThrow(() -> motivoProblemaFamiliar.ejecutarAccionesEspecificas(supervisor, "empleado@test.com"));
    }
}
