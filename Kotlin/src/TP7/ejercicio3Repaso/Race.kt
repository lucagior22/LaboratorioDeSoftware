package TP7.ejercicio3Repaso

import java.time.LocalDateTime
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.random.Random

/*
* Implemente una aplicación que simule una carrera de 100 metros, donde cada
* participante está representado por un objeto thread. Para ello,
* cree un programa que muestre por consola la cantidad de metros
* recorrida por cada corredor.
* a.- Use un ejecutor con un pool de tamaño 5 para ejecutar. Luego
* cambie el tamaño del pool a 3 y observe la ejecución de los
* threads.
* b.- Supongamos que se quiere saber si un corredor abandona la
* carrera, retornando algún valor predefinido o en el peor de los
* casos, disparando una excepción. Analice la interface Callable,
* usando la documentación de la API y observe sus ventajas
 */

fun main () {
    var nThreads = 5
    var futures = ArrayList<Future<String>>()
    val executor = Executors.newFixedThreadPool(nThreads)

    for (i in 1..nThreads) {
        val future : Future<String> = executor.submit<String> {
            val factorSuerteEnCarrera : Long = Random.nextLong(1, 10)
            var factorSuerteEnMetro : Long
            for (m in 1..100) {
                factorSuerteEnMetro = Random.nextLong(1, 100)
                Thread.sleep(factorSuerteEnMetro / factorSuerteEnCarrera)
                if (factorSuerteEnCarrera < 3 && factorSuerteEnMetro < 3) {
                    println("Soy el Thread $i y abandono!")
                    throw Abandono()
                }
            }
            val timestamp = LocalDateTime.now().toLocalTime()
            println("Soy el Thread $i y terminé la carrera a las ${timestamp}!")
            return@submit "${timestamp.second}:${timestamp.nano} Soy el Thread $i y terminé la carrera!"
        }
        futures.addLast(future)
    }
}

class Abandono : Exception();