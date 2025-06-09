package com.excusas.model.excusas.motivos;

import com.excusas.model.email.interfaces.IEmailSender;
import com.excusas.model.email.EmailSenderConcreto;
import com.excusas.model.empleados.interfaces.IEncargado;

public abstract class MotivoModerado extends MotivoExcusa {

    @Override
    public final boolean esAceptablePor(IEncargado encargado) {
        return encargado.puedeManejarModerado();
    }

    @Override
    public final void ejecutarAccionesEspecificas(IEncargado encargado, String emailEmpleado) {
        IEmailSender emailSender = new EmailSenderConcreto();

        emailSender.enviarEmail(
                getDestinatarioEmail(emailEmpleado),
                encargado.getEmail(),
                getAsuntoEmail(),
                getCuerpoEmail()
        );
        System.out.println(getMensajeLog());
    }

    protected abstract String getDestinatarioEmail(String emailEmpleado);
    protected abstract String getAsuntoEmail();
    protected abstract String getCuerpoEmail();
    protected abstract String getMensajeLog();
}
