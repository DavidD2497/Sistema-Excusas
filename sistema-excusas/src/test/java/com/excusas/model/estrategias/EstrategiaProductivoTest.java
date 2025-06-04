package com.excusas.model.estrategias;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EstrategiaProductivoTest {

    private EstrategiaProductivo estrategia;
    private Recepcionista recepcionista;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        estrategia = new EstrategiaProductivo();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Me quedé dormido");
    }

    @Test
    void testCrearEstrategiaProductivo() {
        assertNotNull(estrategia);
    }

    @Test
    void testEjecutarEstrategia() {
        assertDoesNotThrow(() -> estrategia.ejecutarEstrategia(recepcionista, excusa));
    }

    @Test
    void testManejar() {
        assertDoesNotThrow(() -> estrategia.manejar(recepcionista, excusa));
    }
}
