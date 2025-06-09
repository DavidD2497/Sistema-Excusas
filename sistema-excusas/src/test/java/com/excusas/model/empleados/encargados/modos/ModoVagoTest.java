package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.encargados.SupervisorArea;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModoVagoTest {

    private ModoVago modoVago;
    private IEncargado recepcionista;
    private IEncargado supervisor;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        modoVago = new ModoVago();
        recepcionista = new Recepcionista("Laura", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro", "pedro@excusas.com", 2002);

        Empleado empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Llegué tarde");

        recepcionista.setSiguiente(supervisor);
    }

    @Test
    void deberiaDelegarAlSiguienteEncargado() {
        assertDoesNotThrow(() -> {
            modoVago.manejar(recepcionista, excusa);
        });
    }

    @Test
    void noDeberiaFallarCuandoNoHaySiguienteEncargado() {
        IEncargado encargadoSinSiguiente = new Recepcionista("Solo", "solo@excusas.com", 3001);

        assertDoesNotThrow(() -> {
            modoVago.manejar(encargadoSinSiguiente, excusa);
        });
    }
}
