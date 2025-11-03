package ejerciciosIA.Kotlin.ejercicio1

import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.random.Random

/*
Versión 1: Básica con Threads y thread()

Objetivo: Practicar la creación de threads con thread() y el uso de sleep().

Consigna: Implemente una carrera de 100 metros con 5 corredores. Cada corredor es un thread que:

    Arranca en el metro 0
    Avanza de a 10 metros por vez
    Espera un tiempo aleatorio entre 100 y 500 milisegundos entre cada avance
    Imprime en consola: "Corredor #X avanzó Y metros"
    Cuando llega a los 100 metros, imprime: "Corredor #X llegó a la meta!"

Requisitos:

    Use thread() para crear los corredores
    Use TimeUnit.MILLISECONDS.sleep() para simular el tiempo entre avances
    Use join() en el main thread para esperar que todos terminen antes de imprimir "Carrera finalizada"
 */

fun main() {
    val corredores = ArrayList<Thread>()

    // Se crean los threads sin empezar las tareas
    for (i in 1..5) {
        corredores.add(thread(start = false) {
            val id = i
            var metros = 0
            while (metros < 100) {
                metros += 10
                TimeUnit.MILLISECONDS.sleep(Random.nextLong(100, 500))
                println("Corredor #$id avanzó $metros metros!")
            }
            println("#$id TERMINÓ!")
        })
    }

    // Se iteran sobre los threads para que empiecen lo más justo posible
    for (i in 0..4) {
        corredores[i].start()
    }

    for (i in 0..4) {
        corredores[i].join()
    }

    println("Carrera finalizada!")
}