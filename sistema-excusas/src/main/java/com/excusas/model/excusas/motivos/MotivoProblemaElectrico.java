package com.excusas.model.excusas.motivos;

public class MotivoProblemaElectrico extends MotivoModerado {

    private static final String EDESUR_EMAIL = "EDESUR@mailfake.com.ar";

    @Override
    protected String getDestinatarioEmail(String emailEmpleado) {
        return EDESUR_EMAIL;
    }

    @Override
    protected String getAsuntoEmail() {
        return "Consulta corte de luz";
    }

    @Override
    protected String getCuerpoEmail() {
        return "Consulta si hubo corte de luz en la zona";
    }

    @Override
    protected String getMensajeLog() {
        return "Consultando a EDESUR sobre corte de luz en la zona";
    }
}
