package com.excusas.config;

import com.excusas.model.empleados.encargados.*;
import com.excusas.model.estrategias.EstrategiaNormal;
import com.excusas.model.estrategias.EstrategiaProductivo;
import com.excusas.model.estrategias.EstrategiaVago;
import com.excusas.model.prontuarios.AdministradorProntuarios;

public class ConfiguradorSistema {

    private Recepcionista recepcionista;
    private SupervisorArea supervisor;
    private GerenteRecursosHumanos gerente;
    private CEO ceo1;
    private CEO ceo2;
    private CEO ceo3;
    private EncargadoPorDefecto encargadoDefecto;

    public ConfiguradorSistema() {
        inicializarEncargados();
        configurarCadenaResponsabilidad();
        configurarEstrategias();
        configurarObservadores();
    }

    private void inicializarEncargados() {
        recepcionista = new Recepcionista("Laura Recep", "laura@excusas.com", 2001);
        supervisor = new SupervisorArea("Pedro Super", "pedro@excusas.com", 2002);
        gerente = new GerenteRecursosHumanos("Sofia Gerente", "sofia@excusas.com", 2003);
        ceo1 = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
        ceo2 = new CEO("Patricia CEO", "patricia@excusas.com", 2005);
        ceo3 = new CEO("Carlos CEO", "carlos@excusas.com", 2006);
        encargadoDefecto = new EncargadoPorDefecto("Default Handler", "default@excusas.com", 2007);
    }

    private void configurarCadenaResponsabilidad() {
        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo1);
        ceo1.setSiguiente(encargadoDefecto);
    }

    private void configurarEstrategias() {
        recepcionista.setEstrategia(new EstrategiaNormal());
        supervisor.setEstrategia(new EstrategiaVago());
        gerente.setEstrategia(new EstrategiaProductivo());
        ceo1.setEstrategia(new EstrategiaNormal());
        encargadoDefecto.setEstrategia(new EstrategiaNormal());
    }

    private void configurarObservadores() {
        AdministradorProntuarios admin = AdministradorProntuarios.getInstance();
        admin.agregarObservador(ceo1);
        admin.agregarObservador(ceo2);
        admin.agregarObservador(ceo3);
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public SupervisorArea getSupervisor() {
        return supervisor;
    }

    public GerenteRecursosHumanos getGerente() {
        return gerente;
    }

    public CEO getCeo1() {
        return ceo1;
    }

    public CEO getCeo2() {
        return ceo2;
    }

    public CEO getCeo3() {
        return ceo3;
    }

    public EncargadoPorDefecto getEncargadoDefecto() {
        return encargadoDefecto;
    }
}

