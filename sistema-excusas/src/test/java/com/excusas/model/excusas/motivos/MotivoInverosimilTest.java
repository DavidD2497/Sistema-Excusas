package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoInverosimilTest {

    private MotivoInverosimil motivoInverosimil;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoInverosimil = new MotivoInverosimil();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testEsAceptablePorCEO() {
        assertTrue(motivoInverosimil.esAceptablePor(ceo));
    }

    @Test
    void testNoEsAceptablePorOtrosEncargados() {
        assertFalse(motivoInverosimil.esAceptablePor(recepcionista));
        assertFalse(motivoInverosimil.esAceptablePor(supervisor));
        assertFalse(motivoInverosimil.esAceptablePor(gerente));
    }

    @Test
    void testEjecutarAccionesEspecificas() {
        assertDoesNotThrow(() -> motivoInverosimil.ejecutarAccionesEspecificas(ceo, "test@test.com"));
    }
}
