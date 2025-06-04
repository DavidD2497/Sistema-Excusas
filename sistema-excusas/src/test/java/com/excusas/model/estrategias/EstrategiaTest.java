package com.excusas.model.estrategias;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import com.excusas.model.excusas.motivos.MotivoProblemaFamiliar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class EstrategiaTest {

    private Empleado empleado;
    private Excusa excusaTrivial;
    private Excusa excusaProblemaFamiliar;
    private Recepcionista recepcionista;
    private SupervisorArea supervisor;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusaTrivial = new Excusa(empleado, new MotivoTrivial(), "Me quedé dormido");
        excusaProblemaFamiliar = new Excusa(empleado, new MotivoProblemaFamiliar(), "Debo cuidar a mi familiar enfermo");
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);
        recepcionista.setSiguiente(supervisor);
    }

    @Test
    void testEstrategiaNormal() {
        EstrategiaNormal estrategia = new EstrategiaNormal();
        recepcionista.setEstrategia(estrategia);
        assertDoesNotThrow(() -> recepcionista.manejarExcusa(excusaTrivial));
    }

    @Test
    void testEstrategiaNormalConSupervisor() {
        EstrategiaNormal estrategia = new EstrategiaNormal();
        supervisor.setEstrategia(estrategia);
        assertDoesNotThrow(() -> supervisor.manejarExcusa(excusaProblemaFamiliar));
    }

    @Test
    void testEstrategiaVago() {
        EstrategiaVago estrategia = new EstrategiaVago();
        recepcionista.setEstrategia(estrategia);
        supervisor.setEstrategia(new EstrategiaNormal());

        assertDoesNotThrow(() -> recepcionista.manejarExcusa(excusaTrivial));
    }

    @Test
    void testEstrategiaVagoConExcusaProblemaFamiliar() {
        EstrategiaVago estrategia = new EstrategiaVago();
        recepcionista.setEstrategia(estrategia);
        supervisor.setEstrategia(new EstrategiaNormal());
        assertDoesNotThrow(() -> recepcionista.manejarExcusa(excusaProblemaFamiliar));
    }

    @Test
    void testEstrategiaProductivo() {
        EstrategiaProductivo estrategia = new EstrategiaProductivo();
        recepcionista.setEstrategia(estrategia);
        assertDoesNotThrow(() -> recepcionista.manejarExcusa(excusaTrivial));
    }

    @Test
    void testEstrategiaProductivoConSupervisor() {
        EstrategiaProductivo estrategia = new EstrategiaProductivo();
        supervisor.setEstrategia(estrategia);
        assertDoesNotThrow(() -> supervisor.manejarExcusa(excusaProblemaFamiliar));
    }
}

