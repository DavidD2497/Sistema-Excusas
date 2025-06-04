package com.excusas.model.excusas.motivos;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.interfaces.IEncargado;

public class MotivoProblemaFamiliar extends MotivoModerado {

    private final IEmailSender emailSender;

    public MotivoProblemaFamiliar() {
        this.emailSender = new EmailSenderConcreto();
    }

    @Override
    public void ejecutarAccionesEspecificas(IEncargado encargado, String emailEmpleado) {
        this.emailSender.enviarEmail(
                emailEmpleado,
                encargado.getEmail(),
                "Consulta familiar",
                "¿Todo está bien?"
        );
        System.out.println("Preguntando al empleado si todo está bien con el familiar");
    }
}
