package ejercicio1

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class Hora {


    fun metodo1(){
        while(true){
            print("\r" + SimpleDateFormat("dd/mm/yyyy hh:mm:ss").format(Date()))
            Thread.sleep(1000)
            System.out.flush()
        }
    }

    fun metodo2(){
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
}

fun main(){
    val h = Hora()
    h.metodo2()
}