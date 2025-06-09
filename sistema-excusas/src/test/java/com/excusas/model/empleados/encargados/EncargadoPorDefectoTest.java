package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncargadoPorDefectoTest {

    private EncargadoPorDefecto encargadoPorDefecto;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        encargadoPorDefecto = new EncargadoPorDefecto("Default Handler", "default@excusas.com", 2007);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Llegué tarde");
    }

    @Test
    void noDeberiaPoderManejarNingunTipoDeExcusa() {
        assertFalse(encargadoPorDefecto.puedeManejarTrivial());
        assertFalse(encargadoPorDefecto.puedeManejarModerado());
        assertFalse(encargadoPorDefecto.puedeManejarComplejo());
        assertFalse(encargadoPorDefecto.puedeManejarInverosimil());
    }

    @Test
    void deberiaProcesarCualquierExcusaRechazandola() {
        assertDoesNotThrow(() -> {
            encargadoPorDefecto.procesarExcusa(excusa);
        });
    }

    @Test
    void deberiaTenerDatosCorrectosDelEmpleado() {
        assertEquals("Default Handler", encargadoPorDefecto.getNombre());
        assertEquals("default@excusas.com", encargadoPorDefecto.getEmail());
        assertEquals(2007, encargadoPorDefecto.getLegajo());
    }

    @Test
    void deberiaEjecutarProcesamientoDirectamente() {
        assertDoesNotThrow(() -> {
            encargadoPorDefecto.ejecutarProcesamiento(excusa);
        });
    }
}
