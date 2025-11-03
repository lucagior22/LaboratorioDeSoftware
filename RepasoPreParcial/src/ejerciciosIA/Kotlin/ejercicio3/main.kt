package ejerciciosIA.Kotlin.ejercicio3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/*
Versión 3: Sincronización con Objeto Compartido

Objetivo: Practicar sincronización con @Synchronized y uso de un recurso compartido.
Consigna: Implemente la carrera donde todos los corredores comparten un podio (objeto compartido) que registra quiénes van llegando:

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

Requisitos:

    Use un ExecutorService (pool de 5 threads)
    Cada corredor debe llamar a registrarLlegada() cuando llegue a los 100 metros
    El método registrarLlegada() debe estar sincronizado para evitar condiciones de carrera
    Al final, el main thread debe imprimir el podio completo usando mostrarPodio()

Preguntas para reflexionar:

    ¿Qué pasaría si registrarLlegada() NO fuera synchronized?
    ¿Por qué es importante que el método esté sincronizado?

Bonus: Variante con Interrupciones

Si querés practicar el método interrupt():

Consigna: Modifique cualquiera de las versiones anteriores para que:

    Si un corredor no llega en menos de 10 segundos, el main thread lo interrumpe
    El corredor debe capturar la InterruptedException y imprimir: "Corredor #X fue descalificado por tiempo"
 */

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

fun main() {
    race(5, 5)
    println()
    race(3, 5)
}

fun race(nThreads : Int, nRunners : Int) {
    println("=== Carrera con $nRunners corredores / $nThreads threads ===")
    val executor = Executors.newFixedThreadPool(nThreads)
    val podio = Podio()
    for (i in 1..nRunners) {
        val name = "Corredor #" + (100..999).random()
        executor.execute {
            for (meters in 1..100) {
                // Agregamos azar
                Thread.sleep(100)
            }
            podio.registrarLlegada(name)
        }
    }

    executor.shutdown()
    executor.awaitTermination(5, TimeUnit.DAYS) // Simil join

    podio.mostrarPodio()
}