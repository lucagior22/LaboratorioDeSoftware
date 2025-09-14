package TP3.ejercicioseis;

import java.util.*;

public class TestEstudiante {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>(Arrays.asList(
            new Estudiante(19, "Lucía",     "Fernández",  "A-0001",  5),
            new Estudiante(20, "Martín",    "Martínez",   "A-0002",  8),
            new Estudiante(22, "Sofía",     "Rodríguez",  "A-0003", 15),
            new Estudiante(21, "Agustín",   "Benítez",    "A-0004", 12),
            new Estudiante(23, "Valentina", "Gómez",      "A-0005", 20),
            new Estudiante(20, "Juan",      "Montenegro", "A-0006", 10),
            new Estudiante(19, "Camila",    "González",   "A-0007",  6),
            new Estudiante(24, "Nicolás",   "Álvarez",    "A-0008", 24),
            new Estudiante(21, "Florencia", "López",      "A-0009", 14),
            new Estudiante(22, "Tomás",     "Domínguez",  "A-0010", 18)
        ));

        Iterator it = estudiantes.iterator();

        System.out.println("\nNon-sorted:");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return Integer.compare(o1.getMateriasAprobadas(), o2.getMateriasAprobadas());
            }
        });

        it = estudiantes.iterator();

        System.out.println("\nSorted materiasAprobadas ASC:");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return Integer.compare(o2.getEdad(), o1.getEdad());
            }
        });

        it = estudiantes.iterator();

        System.out.println("\nSorted edad DESC:");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return CharSequence.compare(o1.getLegajo(), o2.getLegajo());
            }
        });

        it = estudiantes.iterator();

        System.out.println("\nSorted legajo ASC:");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                String nombreApellidoO1 = o1.getNombre() + " " + o1.getApellido();
                String nombreApellidoO2 = o2.getNombre() + " " + o2.getApellido();
                return CharSequence.compare(nombreApellidoO2, nombreApellidoO1);
            }
        });

        it = estudiantes.iterator();

        System.out.println("\nSorted nombre y apellido DESC:");
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
