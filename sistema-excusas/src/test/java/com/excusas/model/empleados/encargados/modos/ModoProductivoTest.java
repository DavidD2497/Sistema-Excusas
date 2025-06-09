package com.excusas.model.empleados.encargados.modos;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.Recepcionista;
import com.excusas.model.empleados.interfaces.IEncargado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoTrivial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModoProductivoTest {

    private ModoProductivo modoProductivo;
    private IEncargado encargado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        modoProductivo = new ModoProductivo();
        encargado = new Recepcionista("Laura", "laura@excusas.com", 2001);

        Empleado empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoTrivial(), "Llegué tarde");
    }

    @Test
    void deberiaProcesarExcusaYEnviarEmailAlCTO() {
        assertDoesNotThrow(() -> {
            modoProductivo.manejar(encargado, excusa);
        });
    }
}

