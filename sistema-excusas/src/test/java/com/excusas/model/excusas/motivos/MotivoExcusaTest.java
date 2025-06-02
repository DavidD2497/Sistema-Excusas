package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoExcusaTest {

    private MotivoTrivial motivoTrivial;
    private MotivoModerado motivoModerado;
    private MotivoComplejo motivoComplejo;
    private MotivoInverosimil motivoInverosimil;

    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoTrivial = new MotivoTrivial();
        motivoModerado = new MotivoModerado();
        motivoComplejo = new MotivoComplejo();
        motivoInverosimil = new MotivoInverosimil();

        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testMotivoTrivialSoloAceptadoPorRecepcionista() {
        assertTrue(motivoTrivial.esAceptablePor(recepcionista));
        assertFalse(motivoTrivial.esAceptablePor(supervisor));
        assertFalse(motivoTrivial.esAceptablePor(gerente));
        assertFalse(motivoTrivial.esAceptablePor(ceo));
    }

    @Test
    void testMotivoModeradoSoloAceptadoPorSupervisor() {
        assertFalse(motivoModerado.esAceptablePor(recepcionista));
        assertTrue(motivoModerado.esAceptablePor(supervisor));
        assertFalse(motivoModerado.esAceptablePor(gerente));
        assertFalse(motivoModerado.esAceptablePor(ceo));
    }

    @Test
    void testMotivoComplejoSoloAceptadoPorGerente() {
        assertFalse(motivoComplejo.esAceptablePor(recepcionista));
        assertFalse(motivoComplejo.esAceptablePor(supervisor));
        assertTrue(motivoComplejo.esAceptablePor(gerente));
        assertFalse(motivoComplejo.esAceptablePor(ceo));
    }

    @Test
    void testMotivoInverosimilSoloAceptadoPorCEO() {
        assertFalse(motivoInverosimil.esAceptablePor(recepcionista));
        assertFalse(motivoInverosimil.esAceptablePor(supervisor));
        assertFalse(motivoInverosimil.esAceptablePor(gerente));
        assertTrue(motivoInverosimil.esAceptablePor(ceo));
    }
}

