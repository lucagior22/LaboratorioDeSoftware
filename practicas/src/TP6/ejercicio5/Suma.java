package TP6.ejercicio5;

public class Suma {
    public static void main(String[] args){
        int suma=0;
        for(int i=0;i<=args.length - 1;i++)
            try {
                suma+= Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        System.out.print("La suma es:"+suma);
    }
}

/*
a) Ejecútelo ingresando al menos 2 valores. -> Se rompe por mala programación
b) Ahora ejecútelo ingresando: 2 3 four. ¿Qué pasó?. Solucione el problema de manera
que los datos no numéricos sean impresos en la consola con un mensaje y descartados antes
de ser sumados.
c) ¿Por qué no fue necesario capturar la excepción en el inciso a) ?
*/
