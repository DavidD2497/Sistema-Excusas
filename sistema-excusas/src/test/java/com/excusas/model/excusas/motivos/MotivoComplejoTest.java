package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoComplejoTest {

    private MotivoComplejo motivoComplejo;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoComplejo = new MotivoComplejo();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testEsAceptablePorGerente() {
        assertTrue(motivoComplejo.esAceptablePor(gerente));
    }

    @Test
    void testNoEsAceptablePorOtrosEncargados() {
        assertFalse(motivoComplejo.esAceptablePor(recepcionista));
        assertFalse(motivoComplejo.esAceptablePor(supervisor));
        assertFalse(motivoComplejo.esAceptablePor(ceo));
    }

    @Test
    void testEjecutarAccionesEspecificas() {
        assertDoesNotThrow(() -> motivoComplejo.ejecutarAccionesEspecificas(gerente, "test@test.com"));
    }
}

