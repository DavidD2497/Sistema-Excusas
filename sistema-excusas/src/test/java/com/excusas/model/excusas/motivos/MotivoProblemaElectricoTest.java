package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoProblemaElectricoTest {

    private MotivoProblemaElectrico motivoProblemaElectrico;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoProblemaElectrico = new MotivoProblemaElectrico();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testEsAceptablePorSupervisor() {
        assertTrue(motivoProblemaElectrico.esAceptablePor(supervisor));
    }

    @Test
    void testNoEsAceptablePorOtrosEncargados() {
        assertFalse(motivoProblemaElectrico.esAceptablePor(recepcionista));
        assertFalse(motivoProblemaElectrico.esAceptablePor(gerente));
        assertFalse(motivoProblemaElectrico.esAceptablePor(ceo));
    }

    @Test
    void testEjecutarAccionesEspecificas() {
        assertDoesNotThrow(() -> motivoProblemaElectrico.ejecutarAccionesEspecificas(supervisor, "empleado@test.com"));
    }
}

