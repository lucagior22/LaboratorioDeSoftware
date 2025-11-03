package ejerciciosIA.Java.Anotaciones.ejercicio1;

import java.time.LocalDateTime;

@NotificationServer
public class MiServidor {

    @NotifyClient
    public String enviarMensajeBienvenida() {
        return "¡Bienvenido al servidor!";
    }

    @NotifyClient
    public LocalDateTime obtenerFechaHora() {
        return LocalDateTime.now();
    }
}
