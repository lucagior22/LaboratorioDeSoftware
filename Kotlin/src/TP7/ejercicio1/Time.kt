package TP7.ejercicio1

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import java.util.TimerTask


    fun main() {
        while (true) {
            println("Elija un método 1 o 2, 3 para exit:")
            val input = readln()
            if (input == "1") {
                firstMethod()
            } else if (input == "2") {
                secondMethod()
            } else if (input == "3") {
                break
            }
        }
    }

    // Mi primera idea, no se cómo agregarle el exit :)
    fun firstMethod() {
        for (i in 1..100){
            print("\r" + SimpleDateFormat("dd/mm/yyyy hh:mm:ss").format(Date()))
            Thread.sleep(1000)
            System.out.flush()
        }
    }

    // Copilot
    fun secondMethod() {
        val timer = Timer()
        val sdf = SimpleDateFormat("HH:mm:ss")
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
            print("\rHora actual: ${sdf.format(Date())}")
            System.out.flush()
            }
        }, 0, 1000)
        println("Presione Enter para detener...")
        readln()
        timer.cancel()
        println()
    }
