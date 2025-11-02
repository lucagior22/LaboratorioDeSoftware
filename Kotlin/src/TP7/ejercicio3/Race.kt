    package TP7.ejercicio3

    import java.time.LocalDateTime
    import java.util.concurrent.Callable
    import java.util.concurrent.Executors
    import java.util.concurrent.Future
    import kotlin.random.Random

    class Abandono : Exception("Abandoné")

    fun main() {
        simularCarrera(5, 5)
    }

    fun simularCarrera(poolSize: Int, numCorredores: Int) {
        val executor = Executors.newFixedThreadPool(poolSize)
        val futures = mutableListOf<Future<ResultadoCarrera>>()

        val tiempoInicio = System.nanoTime()

        // Crear corredores como Callable
        for (i in 1..numCorredores) {
            val corredor = Callable<ResultadoCarrera> {
                try {
                    for (mts in 1..100) {
                        Thread.sleep(50)

                        // Probabilidad de abandono
                        val concentracion = Random.nextInt(0, 500)
                        if (concentracion == 0) {
                            throw Abandono()
                        }
                    }
                    println("Soy $i y terminé la carrera!")
                    ResultadoCarrera(i, (System.nanoTime() - tiempoInicio)/1000000)
                } catch (e: Abandono) {
                    throw RuntimeException(e)
                }
            }

            futures.add(executor.submit(corredor))
        }

        var resultados = ArrayList<ResultadoCarrera>()

        futures.forEachIndexed { index, future ->
            try {
                val resultado = future.get()
                resultados.add(resultado)
            } catch (e: Exception) {
                println("Corredor ${index + 1}: Error - ${e.message}")
                resultados.add(ResultadoCarrera(index + 1, null))
            }
        }

        resultados.sortBy { it.timestamp ?: Long.MAX_VALUE }

        println("--- Podio ---")
        for ((index, r)in resultados.withIndex()) {
            if (r.timestamp != null) {
                println("${index + 1}: el Thread ${r.id} a las ${r.timestamp}")
            } else {
                println("el Thread ${r.id} abandonó! :(")
            }
        }

        executor.shutdown()
    }

    class ResultadoCarrera(val id : Int, val timestamp: Long?)