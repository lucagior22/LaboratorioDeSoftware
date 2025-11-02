package ejercicio3

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.random.Random

class Abandono : Exception("Abandoné")

fun main() {
    println("=== Simulación de Carrera de 100 metros ===\n")

    // Prueba con pool de 5 threads
    println("--- Pool de 5 threads ---")
    simularCarrera(5, 5)

    Thread.sleep(2000) // Pausa entre simulaciones

    // Prueba con pool de 3 threads
    println("\n--- Pool de 3 threads ---")
    simularCarrera(3, 5)
}

fun simularCarrera(poolSize: Int, numCorredores: Int) {
    val executor = Executors.newFixedThreadPool(poolSize)
    val futures = mutableListOf<Future<String>>()

    // Crear corredores como Callable
    for (i in 1..numCorredores) {
        val corredor = Callable<String> {
            try {
                for (mts in 1..100) {

                    Thread.sleep(50) // Simular tiempo de carrera

                    // Probabilidad de abandono
                    val concentracion = Random.nextInt(0, 1000)
                    if (concentracion == 0) {
                        throw Abandono()
                    } else if (concentracion < 5) {
                        return@Callable "Corredor $i: Abandoné a los $mts metros"
                    }
                }
                "Corredor $i: ¡Terminé la carrera!"
            } catch (e: Abandono) {
                "Corredor $i: Abandoné por lesión"
            }
        }

        // Ejecutar y guardar el Future
        futures.add(executor.submit(corredor))
    }

    // Esperar resultados y mostrarlos
    println("\n--- Resultados ---")
    futures.forEachIndexed { index, future ->
        try {
            val resultado = future.get() // Bloquea hasta obtener resultado
            println(resultado)
        } catch (e: Exception) {
            println("Corredor ${index + 1}: Error - ${e.message}")
        }
    }

    executor.shutdown()
}