package TP5.ejercicio3;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contenedor {

    // Objeto estático para sincronizar el acceso al archivo de log
    private static final Object logLock = new Object();

    // Formateador para la fecha y hora del log
    private static final DateTimeFormatter logFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Test test = new Test();
        Class<?> testClass = test.getClass();

        Servidor serverData = testClass.getAnnotation(Servidor.class);

        String ip = serverData.direccion();
        int port = serverData.puerto();
        String fileName = serverData.archivo();

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

            for (Method m : testClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Invocar.class)) {

                    String path = "/" + m.getName();
                    System.out.println("Creando contexto en: " + path);

                    server.createContext(path, exchange -> {
                        try {
                            // Logueamos la petición
                            logRequest(exchange, fileName);

                            // Invocamos el método anotado
                            Object resultado = m.invoke(test);

                            // --- CORRECCIÓN ---
                            // Comprobamos si el resultado es null (lo que pasa si el método es void)
                            String respuesta;
                            if (resultado != null) {
                                respuesta = resultado.toString();
                            } else {
                                // Si es void, enviamos una respuesta vacía
                                respuesta = "";
                            }
                            // --- FIN CORRECCIÓN ---

                            // Preparamos y enviamos la respuesta
                            byte[] bytesRespuesta = respuesta.getBytes(StandardCharsets.UTF_8);
                            exchange.sendResponseHeaders(200, bytesRespuesta.length);

                            try (OutputStream os = exchange.getResponseBody()) {
                                os.write(bytesRespuesta);
                            }

                        } catch (Exception e) {
                            System.err.println("Error al procesar la solicitud para: " + m.getName());
                            e.printStackTrace();
                            enviarError(exchange, 500, "Error interno del servidor");
                        }
                    });
                }
            }

            server.setExecutor(null);
            server.start();
            System.out.println("Servidor iniciado en http://" + ip + ":" + port);
            System.out.println("Logs guardándose en: " + fileName);

        } catch (IOException e) {
            throw new RuntimeException("No se pudo iniciar el servidor", e);
        }
    }

    /**
     * Escribe una línea de log de forma sincronizada (thread-safe).
     */
    private static void logRequest(HttpExchange exchange, String logFileName) {
        try {
            String ahora = LocalDateTime.now().format(logFormatter);
            String ipCliente = exchange.getRemoteAddress().getHostString();
            String path = exchange.getRequestURI().getPath();

            String logLine = String.format("[%s] IP: %s - Petición: %s%n", ahora, ipCliente, path);

            synchronized (logLock) {
                Files.write(
                        Paths.get(logFileName),
                        logLine.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );
            }
        } catch (IOException e) {
            System.err.println("Error: No se pudo escribir en el archivo de log: " + e.getMessage());
        }
    }

    /**
     * Método de utilidad para enviar respuestas de error HTTP.
     */
    private static void enviarError(HttpExchange exchange, int codigo, String mensaje) {
        try {
            byte[] bytesRespuesta = mensaje.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(codigo, bytesRespuesta.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytesRespuesta);
            }
        } catch (IOException e) {
            System.err.println("Error al enviar respuesta de error: " + e.getMessage());
        }
    }
}