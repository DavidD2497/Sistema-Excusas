package com.excusas.model.estrategias;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EstrategiaVagoTest {

    private EstrategiaVago estrategia;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        estrategia = new EstrategiaVago();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Me quedé dormido");

        recepcionista.setSiguiente(supervisor);
        supervisor.setEstrategia(new EstrategiaNormal());
    }

    @Test
    void testCrearEstrategiaVago() {
        assertNotNull(estrategia);
    }

    @Test
    void testEjecutarEstrategiaConSiguiente() {
        assertDoesNotThrow(() -> estrategia.ejecutarEstrategia(recepcionista, excusa));
    }

    @Test
    void testEjecutarEstrategiaSinSiguiente() {
        recepcionista.setSiguiente(null);
        assertDoesNotThrow(() -> estrategia.ejecutarEstrategia(recepcionista, excusa));
    }

    @Test
    void testManejar() {
        assertDoesNotThrow(() -> estrategia.manejar(recepcionista, excusa));
    }
}

