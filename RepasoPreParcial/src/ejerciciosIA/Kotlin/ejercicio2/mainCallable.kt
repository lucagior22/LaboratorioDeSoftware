package ejerciciosIA.Kotlin.ejercicio2

import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/*
Ejercicio 2 Reversionado: Procesamiento de Pedidos

Objetivo: Practicar Executors con Callable y Future.
Consigna

Sistema de pedidos de restaurante. Cada pedido:

    Tarda entre 1-5 segundos en prepararse
    Calcula costo (cantidad items × precio aleatorio $500-$2000)
    Retorna: ID, tiempo preparación, costo total

Requisitos:

data class ResultadoPedido(
    val id: Int,
    val tiempoMs: Long,
    val costo: Double
)

    Cree 10 pedidos con Callable<ResultadoPedido>
    Use Executors.newFixedThreadPool(5) y luego pruebe con 3
    Obtenga resultados con future.get()
    Muestre resumen:
        Tiempo promedio de preparación
        Costo total de todos los pedidos
 */

fun main() {
    hacerPedidos(10, 5)
    println("\n")
    hacerPedidos(10, 3)
}

fun hacerPedidos(nPedidos : Int, nThreads : Int) {
    val futures = ArrayList<Future<ResultadoPedido>>()

    println("--- $nPedidos pedidos resueltos por $nThreads trabajadores ---")

    val executor = Executors.newFixedThreadPool(nThreads)

    for (id in 1..nPedidos) {
        futures.add(executor.submit<ResultadoPedido> {
            val tiempoMs = (1000L..5000L).random()
            TimeUnit.MILLISECONDS.sleep(tiempoMs)
            val costo = Random.nextLong(1, 10) * Random.nextDouble(500.0, 2000.0) // Items * Precio
            ResultadoPedido(id, tiempoMs, costo)
        })
    }

    val pedidos: List<ResultadoPedido> = futures.map { f ->
        try {
            f.get()
        } catch (e: Exception) {
            println("Uno de los pedidos falló!")
        } as ResultadoPedido
    }

    val promedioMs = pedidos.map { it.tiempoMs }.average()
    val costoTotal = pedidos.sumOf { it.costo }

    println("--- Resultados de pedidos ---")
    println("Promedio de demora: ${promedioMs}ms")
    println("Costo total de los pedidos: $$costoTotal")
    println("Resumen de pedidos:")
    for (p in pedidos) {
        println(p)
    }

    executor.shutdown()
    executor.awaitTermination(1, TimeUnit.DAYS)
}

class ResultadoPedido(
    val id: Int,
    val tiempoMs: Long,
    val costo: Double
) {
    override fun toString(): String {
        return "El pedido #$id tardó ${tiempoMs}ms y costó $$costo!"
    }
}