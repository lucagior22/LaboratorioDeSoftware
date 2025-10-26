package ejercicioocho;

public class TestPiano {

    public static void main(String[] args) {

        // Creamos una instancia de Piano
        Piano miPiano = new Piano();

        // Probamos hacer sonar sin nota
        miPiano.hacerSonar();

        // Probamos hacer sonar con nota y duración
        Notas nota = Notas.DO; // ejemplo, suponiendo que Notas es un enum
        int duracion = 4;
        miPiano.hacerSonar(nota, duracion);

        // Probamos queEs
        System.out.println("Instrumento: " + miPiano.queEs());

        // Probamos afinar
        FrecuenciasDeLA frecuencia = FrecuenciasDeLA.ISO; // ejemplo, suponiendo que es un enum
        miPiano.afinar(frecuencia);

    }
}
