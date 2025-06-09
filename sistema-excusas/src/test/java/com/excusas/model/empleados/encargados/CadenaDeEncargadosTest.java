package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CadenaDeEncargadosTest {

    private CadenaDeEncargados cadena;
    private Empleado empleado;

    @BeforeEach
    void setUp() {
        cadena = new CadenaDeEncargados();
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
    }

    @Test
    void deberiaProcesarExcusaTrivial() {
        Excusa excusaTrivial = new Excusa(empleado, new MotivoTrivial(), "Llegué tarde por el tráfico");

        assertDoesNotThrow(() -> {
            cadena.procesarExcusa(excusaTrivial);
        });
    }

    @Test
    void deberiaProcesarExcusaModerada() {
        Excusa excusaModerada = new Excusa(empleado, new MotivoProblemaFamiliar(), "Problema familiar urgente");

        assertDoesNotThrow(() -> {
            cadena.procesarExcusa(excusaModerada);
        });
    }

    @Test
    void deberiaProcesarExcusaCompleja() {
        Excusa excusaCompleja = new Excusa(empleado, new MotivoComplejo(), "Situación compleja que requiere análisis");

        assertDoesNotThrow(() -> {
            cadena.procesarExcusa(excusaCompleja);
        });
    }

    @Test
    void deberiaProcesarExcusaInverosimil() {
        Excusa excusaInverosimil = new Excusa(empleado, new MotivoInverosimil(), "Me secuestraron los aliens");

        assertDoesNotThrow(() -> {
            cadena.procesarExcusa(excusaInverosimil);
        });
    }
}
