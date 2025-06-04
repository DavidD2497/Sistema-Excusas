package com.excusas.model.prontuarios;

import com.excusas.model.empleados.Empleado;
import com.excusas.model.empleados.encargados.CEO;
import com.excusas.model.excusas.Excusa;
import com.excusas.model.excusas.motivos.MotivoInverosimil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

class AdministradorProntuariosTest {

    private AdministradorProntuarios administrador;
    private Empleado empleado;
    private Excusa excusa;
    private Prontuario prontuario;
    private CEO ceo;

    @BeforeEach
    void setUp() {
        administrador = AdministradorProntuarios.getInstance();
        empleado = new Empleado("Juan Pérez", "juan@empresa.com", 1001);
        excusa = new Excusa(empleado, new MotivoInverosimil(), "Fui abducido por aliens");
        prontuario = new Prontuario(empleado, excusa, 1001);
        ceo = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
    }

    @AfterEach
    void tearDown() {
        administrador.getProntuarios().clear();
    }

    @Test
    void testSingleton() {
        AdministradorProntuarios otraInstancia = AdministradorProntuarios.getInstance();
        assertSame(administrador, otraInstancia);
    }

    @Test
    void testAgregarObservador() {
        administrador.agregarObservador(ceo);
        assertDoesNotThrow(() -> administrador.agregarProntuario(prontuario));
    }

    @Test
    void testEliminarObservador() {
        administrador.agregarObservador(ceo);
        administrador.eliminarObservador(ceo);
        assertDoesNotThrow(() -> administrador.agregarProntuario(prontuario));
    }

    @Test
    void testAgregarProntuario() {
        int cantidadInicial = administrador.getProntuarios().size();
        administrador.agregarProntuario(prontuario);
        assertEquals(cantidadInicial + 1, administrador.getProntuarios().size());
        assertTrue(administrador.getProntuarios().contains(prontuario));
    }

    @Test
    void testNotificarObservadores() {
        administrador.agregarObservador(ceo);
        assertDoesNotThrow(() -> administrador.notificarObservadores(prontuario));
    }

    @Test
    void testGetProntuarios() {
        administrador.agregarProntuario(prontuario);
        assertFalse(administrador.getProntuarios().isEmpty());

        administrador.getProntuarios().clear();
        assertFalse(administrador.getProntuarios().isEmpty());
    }

    @Test
    void testMultiplesObservadores() {
        CEO ceo2 = new CEO("Patricia CEO", "patricia@excusas.com", 2005);
        CEO ceo3 = new CEO("Carlos CEO", "carlos@excusas.com", 2006);

        administrador.agregarObservador(ceo);
        administrador.agregarObservador(ceo2);
        administrador.agregarObservador(ceo3);

        assertDoesNotThrow(() -> administrador.agregarProntuario(prontuario));
    }
}
