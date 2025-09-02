package TP1.ejerciciouno;

import java.util.ArrayList;

public class TestVacuna {


    public static void main(String[] param){

        ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
        for (int i = 0; i < 5; i++) {
            vacunas.add(new Vacuna(
                    "Pfizer",
                    "Argentina",
                    "Sida",
                    i + 1
            ));
        }

//         vacunas.stream().forEach(
//                 vacuna -> {
//                     System.out.println(vacuna.toString());
//                 }
//         );

        Vacuna sputnik = new Vacuna(
                "Sputnik",
                "Rusia",
                "Covid-19",
                3
        );
        Vacuna sputnik2 = new Vacuna(
                "Sputnik",
                "Rusia",
                "Covid-19",
                3
        );

        // Comparamos por contenido utilizando el equals sobrescrito
        if (sputnik.equals(vacunas.getFirst())){
            System.out.println("Son iguales pa");
        }
            else{
            System.out.println("No son iguales pa");
        }

        // Comparamos por contenido utilizando el equals sobrescrito
        if (sputnik.equals(sputnik2)){
            System.out.println("Son iguales pa");
        }
        else{
            System.out.println("No son iguales pa");
        }


    }

}
