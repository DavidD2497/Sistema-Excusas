package com.excusas.model.excusas.motivos;

import com.excusas.model.empleados.encargados.GerenteRecursosHumanos;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.interfaces.IEncargado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotivoComplejoTest {

    private MotivoComplejo motivoComplejo;
    private IEncargado gerente;
    private IEncargado recepcionista;

    @BeforeEach
    void setUp() {
        motivoComplejo = new MotivoComplejo();
        gerente = new GerenteRecursosHumanos("Sofia", "sofia@excusas.com", 2003);
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
    }

    @Test
    void deberiaSerAceptablePorGerente() {
        assertTrue(motivoComplejo.esAceptablePor(gerente));
    }

    @Test
    void noDeberiaSerAceptablePorRecepcionista() {
        assertFalse(motivoComplejo.esAceptablePor(recepcionista));
    }
}
