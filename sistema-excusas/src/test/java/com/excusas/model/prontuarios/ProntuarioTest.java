package com.excusas.model.prontuarios;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoInverosimil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProntuarioTest {

    private Empleado empleado;
    private Excusa excusa;
    private Prontuario prontuario;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoInverosimil(), "Me secuestraron los aliens");
        prontuario = new Prontuario(empleado, excusa, empleado.getLegajo());
    }

    @Test
    void deberiaCrearProntuarioCorrectamente() {
        assertEquals(empleado, prontuario.getEmpleado());
        assertEquals(excusa, prontuario.getExcusa());
        assertEquals(empleado.getLegajo(), prontuario.getLegajo());
    }

    @Test
    void deberiaTenerDatosConsistentes() {
        assertEquals(empleado.getLegajo(), prontuario.getLegajo());
        assertEquals(empleado.getNombre(), prontuario.getEmpleado().getNombre());
        assertEquals(empleado.getEmail(), prontuario.getEmpleado().getEmail());
    }
}

