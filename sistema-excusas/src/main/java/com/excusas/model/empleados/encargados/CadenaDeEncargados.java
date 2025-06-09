package com.excusas.model.empleados.encargados;

import com.excusas.model.excusas.Excusa;
import com.excusas.model.empleados.interfaces.IEncargado;

public class CadenaDeEncargados {

    private final IEncargado primerEncargado;

    public CadenaDeEncargados() {
        this.primerEncargado = this.construirCadena();
    }

    private IEncargado construirCadena() {

        IEncargado recepcionista = new Recepcionista("Laura Recep", "laura@excusas.com", 2001);
        IEncargado supervisor = new SupervisorArea("Pedro Super", "pedro@excusas.com", 2002);
        IEncargado gerente = new GerenteRecursosHumanos("Sofia Gerente", "sofia@excusas.com", 2003);
        IEncargado ceo = new CEO("Roberto CEO", "roberto@excusas.com", 2004);
        IEncargado encargadoDefecto = new EncargadoPorDefecto("Default Handler", "default@excusas.com", 2007);

        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);
        ceo.setSiguiente(encargadoDefecto);

        return recepcionista;
    }

    public void procesarExcusa(Excusa excusa) {
        this.primerEncargado.manejarExcusa(excusa);
    }
}
