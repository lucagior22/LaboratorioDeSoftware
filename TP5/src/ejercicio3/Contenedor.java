package ejercicio3;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.reflect.Method;

public class Contenedor {
    public static void main(String[] args) {

        EjemploServidor serv = new EjemploServidor();
        Class<?> servClass = serv.getClass();

        String direccion = servClass.getAnnotation(Servidor.class).direccion();
        int puerto = servClass.getAnnotation(Servidor.class).puerto();
        String archivo = servClass.getAnnotation(Servidor.class).archivo();

        try {
            // 1️⃣ Crear el servidor HTTP
            HttpServer server = HttpServer.create(new InetSocketAddress(direccion, puerto), 0);

            // 2️⃣ Definir el manejador de peticiones (handler)
            server.createContext("/", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {

                    // IP del cliente que hace la petición
                    String ipCliente = exchange.getRemoteAddress().getAddress().getHostAddress();

                    // Log de fecha, hora e IP
                    LocalDateTime ahora = LocalDateTime.now();
                    String logEntry = String.format("[%s] Cliente conectado desde %s%n",
                            ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                            ipCliente);

                    try {
                        // Escribir en el archivo (append para no sobrescribir)
                        Files.writeString(
                                Paths.get(archivo),
                                logEntry,
                                StandardOpenOption.CREATE,
                                StandardOpenOption.APPEND
                        );
                        System.out.println("Log guardado en " + archivo);
                    } catch (Exception e) {
                        System.out.println("Error al escribir el archivo: " + e.getMessage());
                    }

                    // Invocar métodos anotados con @Invocar
                    for (Method m : servClass.getDeclaredMethods()) {
                        if (m.isAnnotationPresent(Servidor.Invocar.class)) {
                            try {
                                m.invoke(serv);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // Responder al cliente
                    String respuesta = "Petición recibida y procesada correctamente.";
                    exchange.sendResponseHeaders(200, respuesta.getBytes().length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(respuesta.getBytes());
                    }
                }
            });

            // 3️⃣ Iniciar el servidor
            server.start();
            System.out.printf("Servidor iniciado en %s:%d%n", direccion, puerto);

            // 4️⃣ Mantener el programa corriendo
            // (sin esto, main termina y el servidor se apaga)
            System.out.println("Presioná Ctrl + C para detener el servidor.");
            Thread.currentThread().join();  // bloquea el hilo principal

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
