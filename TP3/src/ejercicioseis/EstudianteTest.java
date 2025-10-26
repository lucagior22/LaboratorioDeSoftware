package ejercicioseis;

import java.util.*;
public class EstudianteTest {

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


        Iterator i = estudiantes.iterator();

        System.out.println("Sin ordenar:");
        while (i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("Materias ascendente:");
        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Integer.compare(e1.getMateriasAprobadas(), e2.getMateriasAprobadas());
            }
        });

        i = estudiantes.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("Edad descendente");

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Integer.compare(e2.getEdad(), e1.getEdad());
            }
        });

        i = estudiantes.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return CharSequence.compare(o1.getLegajo(), o2.getLegajo());
            }
        });

        i = estudiantes.iterator();

        System.out.println("\nSorted legajo ASC:");
        while (i.hasNext()){
            System.out.println(i.next());
        }

        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                String nombreApellidoO1 = o1.getNombre() + " " + o1.getApellido();
                String nombreApellidoO2 = o2.getNombre() + " " + o2.getApellido();
                return CharSequence.compare(nombreApellidoO2, nombreApellidoO1);
            }
        });

        i = estudiantes.iterator();

        System.out.println("\nSorted nombre y apellido DESC:");
        while (i.hasNext()){
            System.out.println(i.next());
        }


    }

}
