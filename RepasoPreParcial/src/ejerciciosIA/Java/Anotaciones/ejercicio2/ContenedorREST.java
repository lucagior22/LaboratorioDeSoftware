package ejerciciosIA.Java.Anotaciones.ejercicio2;

import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.lang.reflect.*;
import java.net.InetSocketAddress;
import java.util.Objects;

public class ContenedorREST {
    public static void main(String[] args) {
        TaskAPI taskAPI = new TaskAPI();

        RestAPI restAPIAnnotation = taskAPI.getClass().getAnnotation(RestAPI.class);
        String baseUrl = restAPIAnnotation.baseUrl();
        int port = restAPIAnnotation.port();
        int maxConnections = restAPIAnnotation.maxConnections();

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), maxConnections);

            for (Method m : taskAPI.getClass().getDeclaredMethods()) {
                if (m.isAnnotationPresent(Endpoint.class)) {
                    Endpoint endpoint = m.getAnnotation(Endpoint.class);
                    System.out.println("Endpoint " + endpoint);
                    String compoundUrl = baseUrl + endpoint.path();
                    server.createContext(compoundUrl, exchange -> {
                        try {
                            // Si el httpmethod es distinto al definido -> HTTP 405 Method Not Allowed
                            if (!Objects.equals(exchange.getRequestMethod(), endpoint.method().name())) {
                                exchange.sendResponseHeaders(405, 0);
                                exchange.close();
                            }

                            // Si el method requiere body mando body, sino headers
                            Object responseBody = m.invoke(taskAPI, exchange);

                            System.out.println("Response: " + responseBody);

                            // Respondo con 200 y la respuesta
                            byte[] responseBodyBytes = responseBody.toString().getBytes();
                            exchange.sendResponseHeaders(200, responseBodyBytes.length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(responseBodyBytes);
                            os.close();
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e + " " + e.getMessage());
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
            server.start();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
