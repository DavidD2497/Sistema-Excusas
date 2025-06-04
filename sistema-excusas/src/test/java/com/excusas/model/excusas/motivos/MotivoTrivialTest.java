package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoTrivialTest {

    private MotivoTrivial motivoTrivial;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoTrivial = new MotivoTrivial();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testEsAceptablePorRecepcionista() {
        assertTrue(motivoTrivial.esAceptablePor(recepcionista));
    }

    @Test
    void testNoEsAceptablePorOtrosEncargados() {
        assertFalse(motivoTrivial.esAceptablePor(supervisor));
        assertFalse(motivoTrivial.esAceptablePor(gerente));
        assertFalse(motivoTrivial.esAceptablePor(ceo));
    }

    @Test
    void testEjecutarAccionesEspecificas() {
        assertDoesNotThrow(() -> motivoTrivial.ejecutarAccionesEspecificas(recepcionista, "test@test.com"));
    }
}
