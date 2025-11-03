package ejerciciosIA.Java.Anotaciones.ejercicio1;

import com.sun.net.httpserver.HttpServer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.*;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;

public class ContenedorNotificaciones {
    public static void main(String[] args) {
        MiServidor servidor = new MiServidor();
        Class<?> servidorClass = servidor.getClass();

        NotificationServer servidorAnotacion = servidorClass.getAnnotation(NotificationServer.class);
        int port = servidorAnotacion.port();
        String logFile = servidorAnotacion.logFile();

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

            server.createContext("/notify", exchange -> {
                try {
                    StringBuilder html = new StringBuilder("<div>");
                    FileWriter fileWriter = new FileWriter(logFile, true);
                    fileWriter.write(LocalDateTime.now() + " " + exchange.getRemoteAddress().getHostString() );
                    fileWriter.close();

                    for (Method m : servidorClass.getDeclaredMethods()) {
                        if (m.isAnnotationPresent(NotifyClient.class)) {
                            System.out.println("Procesando: " + m.getName());
                            Object o = m.invoke(servidor);
                            html.append("<h1>").append(o.toString()).append("</h1>");
                        }
                    }
                    html.append("</div>");
                    byte[] bs = html.toString().getBytes();
                    OutputStream os = exchange.getResponseBody();
                    exchange.sendResponseHeaders(200, bs.length);
                    os.write(bs);
                    os.close();
                } catch (Exception e) {
                    System.out.println("Ocurrió un error: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            });

            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            System.out.println("Ocurrió un error...: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
