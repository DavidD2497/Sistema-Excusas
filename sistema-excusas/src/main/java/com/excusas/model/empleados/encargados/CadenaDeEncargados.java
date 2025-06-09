package com.excusas.model.empleados.encargados;

import com.excusas.model.excusas.Excusa;

public class CadenaDeEncargados {

    private final Recepcionista recepcionista;
    private final SupervisorArea supervisor;
    private final GerenteRecursosHumanos gerente;
    private final CEO ceo;
    private final EncargadoPorDefecto encargadoDefecto;

    public CadenaDeEncargados() {
        this.recepcionista = new Recepcionista("Laura Recep", "laura@excusas.com", 2001);
        this.supervisor = new SupervisorArea("Pedro Super", "pedro@excusas.com", 2002);
        this.gerente = new GerenteRecursosHumanos("Sofia Gerente", "sofia@excusas.com", 2003);
        this.ceo = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
        this.encargadoDefecto = new EncargadoPorDefecto("Default Handler", "default@excusas.com", 2007);

        this.configurarCadenaResponsabilidad();
    }

    private void configurarCadenaResponsabilidad() {
        this.recepcionista.setSiguiente(this.supervisor);
        this.supervisor.setSiguiente(this.gerente);
        this.gerente.setSiguiente(this.ceo);
        this.ceo.setSiguiente(this.encargadoDefecto);
    }

    public void procesarExcusa(Excusa excusa) {
        this.recepcionista.manejarExcusa(excusa);
    }
}
