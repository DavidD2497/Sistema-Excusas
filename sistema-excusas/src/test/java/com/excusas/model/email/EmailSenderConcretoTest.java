package com.excusas.model.email;

import com.excusas.exceptions.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailSenderConcretoTest {

    private EmailSenderConcreto emailSender;

    @BeforeEach
    void setUp() {
        emailSender = EmailSenderConcreto.getInstance();
    }

    @Test
    void deberiaEnviarEmailCorrectamente() {
        String destino = "destino@empresa.com";
        String origen = "origen@empresa.com";
        String asunto = "Asunto de prueba";
        String cuerpo = "Cuerpo del mensaje";

        assertDoesNotThrow(() -> {
            emailSender.enviarEmail(destino, origen, asunto, cuerpo);
        });
    }

    @Test
    void deberiaLanzarExcepcionCuandoDestinoEsNulo() {
        EmailException exception = assertThrows(EmailException.class, () -> {
            emailSender.enviarEmail(null, "origen@empresa.com", "Asunto", "Cuerpo");
        });

        assertEquals("Error al enviar email: El email de destino no puede estar vacío", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoDestinoEstaVacio() {
        EmailException exception = assertThrows(EmailException.class, () -> {
            emailSender.enviarEmail("   ", "origen@empresa.com", "Asunto", "Cuerpo");
        });

        assertEquals("Error al enviar email: El email de destino no puede estar vacío", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoOrigenEsNulo() {
        EmailException exception = assertThrows(EmailException.class, () -> {
            emailSender.enviarEmail("destino@empresa.com", null, "Asunto", "Cuerpo");
        });

        assertEquals("Error al enviar email: El email de origen no puede estar vacío", exception.getMessage());
    }

    @Test
    void deberiaLanzarExcepcionCuandoAsuntoEsNulo() {
        EmailException exception = assertThrows(EmailException.class, () -> {
            emailSender.enviarEmail("destino@empresa.com", "origen@empresa.com", null, "Cuerpo");
        });

        assertEquals("Error al enviar email: El asunto no puede estar vacío", exception.getMessage());
    }
}

