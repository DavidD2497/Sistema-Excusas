package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MotivoModeradoTest {

    private MotivoProblemaFamiliar motivoProblemaFamiliar;
    private MotivoProblemaElectrico motivoProblemaElectrico;

    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        motivoProblemaFamiliar = new MotivoProblemaFamiliar();
        motivoProblemaElectrico = new MotivoProblemaElectrico();

        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
    }

    @Test
    void testComportamientoPolimórfico() {
        assertTrue(motivoProblemaFamiliar.esAceptablePor(supervisor));
        assertTrue(motivoProblemaElectrico.esAceptablePor(supervisor));

        assertFalse(motivoProblemaFamiliar.esAceptablePor(recepcionista));
        assertFalse(motivoProblemaFamiliar.esAceptablePor(gerente));
        assertFalse(motivoProblemaFamiliar.esAceptablePor(ceo));
    }

    @Test
    void testAccionesEspecificasDiferentes() {
        assertDoesNotThrow(() -> {
            motivoProblemaFamiliar.ejecutarAccionesEspecificas(supervisor, "empleado@test.com");
            motivoProblemaElectrico.ejecutarAccionesEspecificas(supervisor, "empleado@test.com");
        });
    }
}
