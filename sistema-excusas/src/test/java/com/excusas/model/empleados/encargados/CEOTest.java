package com.excusas.model.empleados.encargados;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoInverosimil;
import com.excusas.model.prontuarios.AdministradorProntuarios;
import com.excusas.model.prontuarios.Prontuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

class CEOTest {

    private CEO ceo;
    private Empleado empleado;
    private Excusa excusa;

    @BeforeEach
    void setUp() {
        ceo = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoInverosimil(), "Fui abducido por aliens");
    }

    @AfterEach
    void tearDown() {
        AdministradorProntuarios.getInstance().getProntuarios().clear();
    }

    @Test
    void testCrearCEO() {
        assertNotNull(ceo);
        assertEquals("Roberto CEO", ceo.getNombre());
        assertEquals("roberto@excusas.com", ceo.getEmail());
        assertEquals(2004, ceo.getLegajo());
    }

    @Test
    void testCapacidadesManejoExcusas() {
        assertFalse(ceo.puedeManejarTrivial());
        assertFalse(ceo.puedeManejarModerado());
        assertFalse(ceo.puedeManejarComplejo());
        assertTrue(ceo.puedeManejarInverosimil());
    }

    @Test
    void testProcesarExcusa() {
        int prontuariosIniciales = AdministradorProntuarios.getInstance().getProntuarios().size();

        assertDoesNotThrow(() -> ceo.procesarExcusa(excusa));
        assertEquals(prontuariosIniciales + 1, AdministradorProntuarios.getInstance().getProntuarios().size());
    }

    @Test
    void testActualizarObserver() {
        Prontuario prontuario = new Prontuario(empleado, excusa, 1001);
        assertDoesNotThrow(() -> ceo.actualizar(prontuario));
    }

}
