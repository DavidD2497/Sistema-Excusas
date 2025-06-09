package com.excusas.model.excusas.motivos;
public class MotivoProblemaFamiliar extends MotivoModerado {

    @Override
    protected String getDestinatarioEmail(String emailEmpleado) {
        return emailEmpleado;
    }

    @Override
    protected String getAsuntoEmail() {
        return "Consulta familiar";
    }

    @Override
    protected String getCuerpoEmail() {
        return "¿Todo está bien con tu familiar?";
    }

    @Override
    protected String getMensajeLog() {
        return "Preguntando al empleado si todo está bien con el familiar";
    }
}


