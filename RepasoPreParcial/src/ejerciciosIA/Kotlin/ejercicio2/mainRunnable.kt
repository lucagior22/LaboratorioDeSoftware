package ejerciciosIA.Kotlin.ejercicio2

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/*
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
*/

fun main(){
    race(5, 5)
    race(3, 5)
}

fun race(nThreads : Int, nRunners : Int) {
    println("=== Carrera con $nRunners corredores / $nThreads threads ===")
    val executor = Executors.newFixedThreadPool(nThreads)

    for (i in 1..nRunners) {
        executor.execute {
            for (meters in 1..100) {
                // Agregamos azar
                Thread.sleep(100)
            }
            println("Runner $i: Terminé!!")
        }
    }

    executor.shutdown()
    executor.awaitTermination(5, TimeUnit.DAYS) // Simil join
}