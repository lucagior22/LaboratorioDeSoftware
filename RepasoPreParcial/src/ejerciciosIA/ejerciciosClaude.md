# Ejercicios de Práctica: Carrera de 100 metros

Basándome en los conceptos vistos en la clase, te propongo 3 versiones del ejercicio de la carrera con diferentes niveles de complejidad:

---

## **Versión 1: Básica con Threads y thread()**

**Objetivo:** Practicar la creación de threads con `thread()` y el uso de `sleep()`.

**Consigna:**
Implemente una carrera de 100 metros con 5 corredores. Cada corredor es un thread que:
- Arranca en el metro 0
- Avanza de a 10 metros por vez
- Espera un tiempo aleatorio entre 100 y 500 milisegundos entre cada avance
- Imprime en consola: `"Corredor #X avanzó Y metros"`
- Cuando llega a los 100 metros, imprime: `"Corredor #X llegó a la meta!"`

**Requisitos:**
- Use `thread()` para crear los corredores
- Use `TimeUnit.MILLISECONDS.sleep()` para simular el tiempo entre avances
- Use `join()` en el main thread para esperar que todos terminen antes de imprimir "Carrera finalizada"

---

## **Versión 2: Con Executors y Pool de Threads**

**Objetivo:** Practicar el uso de Executors con `newFixedThreadPool()` y el método `shutdown()`.

**Consigna:**
Modifique el ejercicio anterior para usar un Executor con un pool de threads:
- Cree un `ExecutorService` con `Executors.newFixedThreadPool(5)` para 5 corredores
- Cada corredor debe ejecutarse como una tarea usando `execute { }`
- Después de lanzar todas las tareas, invoque `shutdown()` para cerrar el executor
- Use `awaitTermination()` para esperar que todas las tareas terminen

**Experimento:**
- Ejecute primero con pool de tamaño 5
- Luego cambie a pool de tamaño 3 y observe qué sucede (algunos threads esperan a que se liberen recursos)

---

## **Versión 3: Sincronización con Objeto Compartido**

**Objetivo:** Practicar sincronización con `@Synchronized` y uso de un recurso compartido.

**Consigna:**
Implemente la carrera donde todos los corredores comparten un **podio** (objeto compartido) que registra quiénes van llegando:

```kotlin
class Podio {
    private val llegadas = mutableListOf<String>()
    
    @Synchronized
    fun registrarLlegada(corredor: String): Int {
        llegadas.add(corredor)
        val posicion = llegadas.size
        println("$corredor llegó en posición $posicion")
        return posicion
    }
    
    @Synchronized
    fun mostrarPodio() {
        println("\n=== PODIO FINAL ===")
        llegadas.forEachIndexed { index, corredor ->
            println("${index + 1}° lugar: $corredor")
        }
    }
}
```

**Requisitos:**
- Use un `ExecutorService` (pool de 5 threads)
- Cada corredor debe llamar a `registrarLlegada()` cuando llegue a los 100 metros
- El método `registrarLlegada()` debe estar sincronizado para evitar condiciones de carrera
- Al final, el main thread debe imprimir el podio completo usando `mostrarPodio()`

**Preguntas para reflexionar:**
- ¿Qué pasaría si `registrarLlegada()` NO fuera synchronized?
- ¿Por qué es importante que el método esté sincronizado?

---

## **Bonus: Variante con Interrupciones**

Si querés practicar el método `interrupt()`:

**Consigna:**
Modifique cualquiera de las versiones anteriores para que:
- Si un corredor no llega en menos de 10 segundos, el main thread lo interrumpe
- El corredor debe capturar la `InterruptedException` y imprimir: `"Corredor #X fue descalificado por tiempo"`

---

¿Con cuál versión querés que empiece? ¿O necesitás que te dé código de ejemplo para alguna?