package ejercicio3

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.random.Random
import kotlin.random.nextInt


class Carrera {

    val cantCorredores = 5
    val cantThreads = 5
    val exec = Executors.newFixedThreadPool(cantThreads)
    val futures = mutableListOf<Future<String>>()

    fun simularCarrera() {

        for (i in 1..cantCorredores) {
            val corredor = Callable<String> {
                var mts = 0
                var concentracion = 100
                try {
                    while (mts <= 1000) {
                        Thread.sleep(50) // S
                        mts += Random.nextInt(0, 100)
                        concentracion = Random.nextInt(0, 100)

                    }
                    if (concentracion < 5) {
                        throw Exception("Abandono")
                    } else if (concentracion < 10) {
                        return@Callable "El corredor $i abandono a los $mts metros"
                    }
                    "El corredor $i termino la carrera"
                } catch (e: Exception) {
                    "Corredor $i freno por lo siguiuente: $e"
                }
            }
            futures.add(exec.submit(corredor))
        }
    }

    fun esperarResultados() {
        println("\n--- Resultados ---")
        futures.forEachIndexed { index, future ->
            try {
                val resultado = future.get() // Bloquea hasta obtener resultado
                println(resultado)
            } catch (e: Exception) {
                println("Corredor ${index + 1}: Error - ${e.message}")
            }
        }
        exec.shutdown()
    }
}

fun main(){

    val c = Carrera()
    c.simularCarrera()
    c.esperarResultados()

}