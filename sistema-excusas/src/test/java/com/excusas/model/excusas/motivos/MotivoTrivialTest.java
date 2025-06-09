package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.empleados.interfaces.IEncargado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotivoTrivialTest {

    private MotivoTrivial motivoTrivial;
    private IEncargado recepcionista;
    private IEncargado supervisor;

    @BeforeEach
    void setUp() {
        motivoTrivial = new MotivoTrivial();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
    }

    @Test
    void deberiaSerAceptablePorRecepcionista() {
        assertTrue(motivoTrivial.esAceptablePor(recepcionista));
    }

    @Test
    void noDeberiaSerAceptablePorSupervisor() {
        assertFalse(motivoTrivial.esAceptablePor(supervisor));
    }
}

