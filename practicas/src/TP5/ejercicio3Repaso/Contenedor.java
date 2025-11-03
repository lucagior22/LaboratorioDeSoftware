package TP5.ejercicio3Repaso;

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.lang.reflect.*;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.Formattable;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Contenedor {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class<?> myClassClass = myClass.getClass();

        Servidor serverAnnotation = myClassClass.getAnnotation(Servidor.class);

        String ip = serverAnnotation.ip();
        int port = serverAnnotation.port();
        String loggingFilePath = serverAnnotation.loggingFile();

        try  {
            HttpServer server = HttpServer.create(new InetSocketAddress(ip, port), 0);
            server.createContext( "/",
                    exchange -> {
                        System.out.println("Iniciando handle");
                        InetSocketAddress clientIP = exchange.getRemoteAddress();
                        try {
                            FileWriter fileWriter = new FileWriter(loggingFilePath, true);
                            fileWriter.write(LocalDateTime.now() + " ; ClientIP: " + clientIP.getHostString() + "\n");
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el log: " + e.getMessage());
                        }
                        for (Method m : myClassClass.getDeclaredMethods()) {
                            if (m.isAnnotationPresent(Invocar.class)) {
                                try {
                                    m.invoke(myClass);
                                } catch (IllegalAccessException e) {
                                    System.out.println("IllegalAccessException on " + m.getName());
                                    throw new RuntimeException(e);
                                } catch (InvocationTargetException e) {
                                    System.out.println("InvocationTargetException on " + m.getName());
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        exchange.sendResponseHeaders(200, 0);
                        exchange.close();
                    });
            server.setExecutor(null);

            server.start();
        } catch (IOException ioE) {
            throw new RuntimeException(ioE);
        }
    }
}

