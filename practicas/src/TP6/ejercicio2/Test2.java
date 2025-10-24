package TP6.ejercicio2;

public class Test2 {
    public int unMetodo(){
        try {
            System.out.println("Va a retornar 1");
            return 1;
        } finally { // El bloque finally se ejecuta *SIEMPRE*
            System.out.println("Va a retornar 2");
            return 2;
        }
    }

    public static void main(String[] args) {
            Test2 res = new Test2();
            System.out.println(res.unMetodo());
            /*
                Va a retornar 1
                Va a retornar 2
                2
             */
    }
}
