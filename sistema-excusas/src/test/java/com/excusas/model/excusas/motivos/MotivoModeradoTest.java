package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.interfaces.IEncargado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotivoModeradoTest {

    private MotivoProblemaElectrico motivoProblemaElectrico;
    private MotivoProblemaFamiliar motivoProblemaFamiliar;
    private IEncargado supervisor;
    private IEncargado recepcionista;

    @BeforeEach
    void setUp() {
        motivoProblemaElectrico = new MotivoProblemaElectrico();
        motivoProblemaFamiliar = new MotivoProblemaFamiliar();
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
    }

    @Test
    void motivoProblemaElectrico_deberiaSerAceptablePorSupervisor() {
        assertTrue(motivoProblemaElectrico.esAceptablePor(supervisor));
    }

    @Test
    void motivoProblemaElectrico_noDeberiaSerAceptablePorRecepcionista() {
        assertFalse(motivoProblemaElectrico.esAceptablePor(recepcionista));
    }

    @Test
    void motivoProblemaElectrico_deberiaEjecutarAccionesEspecificasCorrectamente() {
        String emailEmpleado = "empleado@empresa.com";

        assertDoesNotThrow(() -> {
            motivoProblemaElectrico.ejecutarAccionesEspecificas(supervisor, emailEmpleado);
        });
    }

    @Test
    void motivoProblemaFamiliar_deberiaSerAceptablePorSupervisor() {
        assertTrue(motivoProblemaFamiliar.esAceptablePor(supervisor));
    }

    @Test
    void motivoProblemaFamiliar_noDeberiaSerAceptablePorRecepcionista() {
        assertFalse(motivoProblemaFamiliar.esAceptablePor(recepcionista));
    }

    @Test
    void motivoProblemaFamiliar_deberiaEjecutarAccionesEspecificasCorrectamente() {
        String emailEmpleado = "empleado@empresa.com";

        assertDoesNotThrow(() -> {
            motivoProblemaFamiliar.ejecutarAccionesEspecificas(supervisor, emailEmpleado);
        });
    }

    @Test
    void ambosMotivos_deberianSerModerados() {
        assertTrue(motivoProblemaElectrico.esAceptablePor(supervisor));
        assertTrue(motivoProblemaFamiliar.esAceptablePor(supervisor));

        assertFalse(motivoProblemaElectrico.esAceptablePor(recepcionista));
        assertFalse(motivoProblemaFamiliar.esAceptablePor(recepcionista));
    }

    @Test
    void ambosMotivos_deberianEjecutarAccionesEspecificas() {
        String emailEmpleado = "test@empresa.com";

        assertDoesNotThrow(() -> {
            motivoProblemaElectrico.ejecutarAccionesEspecificas(supervisor, emailEmpleado);
            motivoProblemaFamiliar.ejecutarAccionesEspecificas(supervisor, emailEmpleado);
        });
    }
}
