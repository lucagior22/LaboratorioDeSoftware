package ejerciciosIA.Java.Anotaciones.ejercicio2;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestAPI(
        port = 4000,
        maxConnections = 10
)
public class TaskAPI {
    private List<String> tasks = new ArrayList<>();

    @Endpoint(path = "/gettasks", method = HTTPMethods.GET)
    public String getTasks(HttpExchange exchange) {
        System.out.println("Se retornan todas las tareas: " + tasks);
        return tasks.toString();
    }

    @Endpoint(path = "/tasks", method = HTTPMethods.POST)
    public boolean addTask(HttpExchange exchange) {
        try {
            byte[] body = exchange.getRequestBody().readAllBytes();
            String task = new String(body);
            System.out.println("Se agrega la siguiente tarea: " + task);
            return tasks.add(task);
        } catch (IOException e) {
            System.out.println("Error en addTask: " + " " + e + " " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Endpoint(path = "/tasks/count", method = HTTPMethods.GET)
    public int countTasks(HttpExchange exchange) {
        System.out.println("Se retornan la cantidad de tareas: " + tasks.size());
        return tasks.size();
    }

}
