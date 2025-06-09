package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.CEO;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.interfaces.IEncargado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotivoInverosimilTest {

    private MotivoInverosimil motivoInverosimil;
    private IEncargado ceo;
    private IEncargado recepcionista;

    @BeforeEach
    void setUp() {
        motivoInverosimil = new MotivoInverosimil();
        ceo = new CEO("Roberto", "roberto@excusas.com", 2004);
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
    }

    @Test
    void deberiaSerAceptablePorCEO() {
        assertTrue(motivoInverosimil.esAceptablePor(ceo));
    }

    @Test
    void noDeberiaSerAceptablePorRecepcionista() {
        assertFalse(motivoInverosimil.esAceptablePor(recepcionista));
    }
}

