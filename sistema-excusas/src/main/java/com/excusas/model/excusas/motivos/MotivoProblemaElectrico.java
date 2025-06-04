package com.excusas.model.excusas.motivos;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.interfaces.IEncargado;

public class MotivoProblemaElectrico extends MotivoModerado {

    private final IEmailSender emailSender;

    public MotivoProblemaElectrico() {
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public void ejecutarAccionesEspecificas(IEncargado encargado, String emailEmpleado) {
        this.emailSender.enviarEmail(
                "EDESUR@mailfake.com.ar",
                encargado.getEmail(),
                "Consulta corte de luz",
                "Consulta si hubo corte de luz"
        );
        System.out.println("Consultando a EDESUR sobre corte de luz");
    }
}


