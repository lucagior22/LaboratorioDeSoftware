# Ejercicios de Anotaciones, Reflection y Java.Net

Basándome en los conceptos de la clase y enfocándome en el punto 3 de la práctica, te propongo ejercicios con **anotaciones personalizadas + reflection + servidores HTTP**.

---

## **Ejercicio 1: Sistema de Notificaciones Push (Básico)**

**Objetivo:** Practicar creación de anotaciones marker, reflection básico y servidor HTTP simple.

### **Consigna:**

Implemente un sistema donde un servidor HTTP envía notificaciones a clientes conectados.

**a)** Defina la anotación `@NotificationServer` que marca una clase como servidor de notificaciones:
- `puerto`: puerto donde escucha (default: 8080)
- `logFile`: archivo donde se registran las conexiones (default: "notifications.log")

**b)** Defina la anotación marker `@NotifyClient` que marca métodos que serán invocados cuando un cliente se conecta.

**c)** Cree una clase `MiServidor` anotada con `@NotificationServer` que tenga:
- Un método `enviarMensajeBienvenida()` anotado con `@NotifyClient` que retorne "¡Bienvenido al servidor!"
- Un método `obtenerFechaHora()` anotado con `@NotifyClient` que retorne la fecha y hora actual

**d)** Implemente la clase `ContenedorNotificaciones` que:
- Use reflection para leer las anotaciones de `MiServidor`
- Cree un `HttpServer` en el puerto especificado
- Al recibir una petición en `/notify`:
    - Registre en el log: fecha, hora e IP del cliente
    - Invoque TODOS los métodos anotados con `@NotifyClient`
    - Retorne al cliente un HTML con los resultados de todos los métodos

**e)** Pruebe con un navegador accediendo a `http://localhost:8080/notify`

---

## **Ejercicio 2: API REST de Tareas (Intermedio)**

**Objetivo:** Practicar anotaciones con parámetros, múltiples contexts y métodos HTTP.

### **Consigna:**

Implemente una API REST básica para gestionar tareas (TODO list).

**a)** Defina la anotación `@RestAPI`:
- `baseUrl`: URL base (ej: "/api")
- `puerto`: puerto del servidor
- `maxConnections`: máximo de conexiones simultáneas

**b)** Defina la anotación `@Endpoint`:
- `path`: ruta del endpoint (ej: "/tasks")
- `method`: método HTTP ("GET", "POST", "DELETE")

**c)** Cree una clase `TaskAPI` anotada con `@RestAPI` que tenga:
- `@Endpoint(path="/tasks", method="GET")`: retorna lista de tareas en formato JSON
- `@Endpoint(path="/tasks", method="POST")`: crea una nueva tarea
- `@Endpoint(path="/tasks/count", method="GET")`: retorna cantidad de tareas

**d)** Implemente la clase `ContenedorREST` que:
- Procese las anotaciones con reflection
- Cree un `HttpServer` con múltiples contexts (uno por cada `@Endpoint`)
- Cada context debe invocar el método correspondiente según el path
- Use `HttpExchange.getRequestMethod()` para validar el método HTTP
- Retorne respuestas en formato JSON

**Pistas:**
```java
String method = exchange.getRequestMethod(); // "GET", "POST", etc
String path = exchange.getRequestURI().getPath(); // "/api/tasks"
```

---

## **Ejercicio 3: Sistema de Autenticación con Roles (Avanzado)**

**Objetivo:** Practicar anotaciones complejas, validación con reflection y manejo de sesiones.

### **Consigna:**

Implemente un servidor HTTP con sistema de autenticación y control de acceso basado en roles.

**a)** Defina las siguientes anotaciones:

```java
@AuthServer(puerto=8080, sessionTimeout=300, authFile="users.txt")

@RequireAuth(roles={"ADMIN", "USER"}) // puede tener múltiples roles

@Login // marca el método de login

@Logout // marca el método de logout
```

**b)** Cree una clase `SecureAPI` anotada con `@AuthServer` que tenga:
- `login()` anotado con `@Login`: valida usuario/password y genera un token de sesión
- `logout()` anotado con `@Logout`: invalida el token
- `verDatos()` anotado con `@RequireAuth(roles={"USER", "ADMIN"})`: retorna datos del usuario
- `eliminarUsuario()` anotado con `@RequireAuth(roles={"ADMIN"})`: solo accesible por admin

**c)** Implemente la clase `ContenedorSeguro` que:
- Use reflection para procesar todas las anotaciones
- Cree un `HttpServer` con contexts para cada método
- Gestione un `Map<String, Session>` para almacenar sesiones activas
- Antes de invocar métodos con `@RequireAuth`:
    - Valide que existe un token válido en los headers: `Authorization: Bearer <token>`
    - Valide que el usuario tiene alguno de los roles requeridos
    - Si no cumple, retorne `401 Unauthorized` o `403 Forbidden`
- Registre en el archivo especificado: fecha, hora, IP, usuario y acción realizada

**d)** Estructura sugerida para Session:
```java
class Session {
    String token;
    String username;
    Set<String> roles;
    long expirationTime;
}
```

**e)** Pruebe con:
- `curl` o Postman haciendo login, obteniendo el token y accediendo a recursos protegidos
- Intente acceder sin token o con roles insuficientes

**Desafíos adicionales:**
- Implemente timeout de sesiones (usar `sessionTimeout` de la anotación)
- Agregue `@RateLimit(requestsPerMinute=10)` para limitar peticiones por IP
- Soporte para CORS headers

---

## **Preguntas de reflexión para todos los ejercicios:**

1. ¿Por qué es necesario `@Retention(RetentionPolicy.RUNTIME)` en estas anotaciones?
2. ¿Qué pasaría si usáramos `RetentionPolicy.SOURCE`?
3. ¿Cuál es la diferencia entre `isAnnotationPresent()` y `getAnnotation()`?
4. ¿Por qué usamos `Method.invoke()` y qué parámetros recibe?
5. En el ejercicio 3, ¿cómo evitarías que dos usuarios usen el mismo token?

---

¿Con cuál ejercicio querés empezar? ¿Necesitás alguna aclaración sobre Java.Net o reflection antes de comenzar?