package com.excusas.model.prontuarios;

import com.excusas.exceptions.ProntuarioException;
import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.CEO;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoInverosimil;
import com.excusas.model.empleados.interfaces.IEncargado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdministradorProntuariosTest {

    private AdministradorProntuarios administrador;
    private Empleado empleado;
    private Excusa excusa;
    private IEncargado ceo;

    @BeforeEach
    void setUp() {
        administrador = AdministradorProntuarios.getInstance();
        administrador.limpiarProntuarios(); // Limpiar para cada test
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoInverosimil(), "Me secuestraron los aliens");
        ceo = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
    }

    @Test
    void deberiaCrearProntuarioCuandoCEOProcesaExcusaInverosimil() {
        int prontuariosIniciales = administrador.getProntuarios().size();

        administrador.notificarExcusaProcesada(excusa, ceo);

        assertEquals(prontuariosIniciales + 1, administrador.getProntuarios().size());
    }

    @Test
    void deberiaLanzarExcepcionCuandoProntuarioEsNulo() {
        ProntuarioException exception = assertThrows(ProntuarioException.class, () -> {
            administrador.agregarProntuario(null);
        });

        assertEquals("El prontuario no puede ser nulo", exception.getMessage());
    }

    @Test
    void deberiaLimpiarProntuariosCorrectamente() {
        Prontuario prontuario = new Prontuario(empleado, excusa, empleado.getLegajo());
        administrador.agregarProntuario(prontuario);

        administrador.limpiarProntuarios();

        assertTrue(administrador.getProntuarios().isEmpty());
    }
}

