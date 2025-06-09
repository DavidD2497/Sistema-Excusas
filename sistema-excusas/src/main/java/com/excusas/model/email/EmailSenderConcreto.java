package com.excusas.model.email;

import com.excusas.exceptions.EmailException;
import com.excusas.model.email.interfaces.IEmailSender;

public class EmailSenderConcreto implements IEmailSender {

    private static EmailSenderConcreto instancia;

    private EmailSenderConcreto() {
    }

    public static EmailSenderConcreto getInstance() {
        if (instancia == null) {
            instancia = new EmailSenderConcreto();
        }
        return instancia;
    }

    @Override
    public void enviarEmail(String unEmailDestino, String unEmailOrigen, String unAsunto, String unCuerpo) {
        try {
            if (unEmailDestino == null || unEmailDestino.trim().isEmpty()) {
                throw new EmailException("El email de destino no puede estar vacío");
            }
            if (unEmailOrigen == null || unEmailOrigen.trim().isEmpty()) {
                throw new EmailException("El email de origen no puede estar vacío");
            }
            if (unAsunto == null || unAsunto.trim().isEmpty()) {
                throw new EmailException("El asunto no puede estar vacío");
            }

            System.out.println("=== EMAIL ENVIADO ===");
            System.out.println("Para: " + unEmailDestino);
            System.out.println("De: " + unEmailOrigen);
            System.out.println("Asunto: " + unAsunto);
            System.out.println("Cuerpo: " + unCuerpo);
            System.out.println("====================");
        } catch (Exception e) {
            throw new EmailException("Error al enviar email: " + e.getMessage(), e);
        }
    }
}
