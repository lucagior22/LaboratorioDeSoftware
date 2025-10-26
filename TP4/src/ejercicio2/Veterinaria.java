package ejercicio2;

public class Veterinaria<E> {


        private E animal;
        public void setAnimal(E x) {
            animal = x;
        }
        public E getAnimal() {
            return animal;
        }

    public class Animal{
    }
    public class Gato extends Animal {
    }
    public class Perro extends Animal {
    }

}

