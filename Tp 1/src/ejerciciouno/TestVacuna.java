package ejerciciouno;

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

        vacunas.stream().forEach(
                vacuna -> {
                    System.out.println(vacuna.toString());
                }
        );
    }

}
