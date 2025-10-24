package TP6.ejercicio4;

class FutbolException extends Exception{}

class Falta extends FutbolException{}

class EquipoIncompleto extends FutbolException{}

class ClimaException extends Exception{}

class Lluvia extends ClimaException{}

class Mano extends Falta{}

class Partido {
    Partido() throws FutbolException{}

    void eventoPartido() throws FutbolException{}
    void jugada() throws EquipoIncompleto, Falta{}
    void penal(){}
}

interface Tormenta {
    void eventoTormenta() throws Lluvia;
    void diluvio() throws Lluvia;
}

public class Encuentro extends Partido implements Tormenta {
    Encuentro() throws Lluvia, FutbolException{}
    Encuentro (String fecha) throws Falta, FutbolException {}

    void penal() {}
    public void eventoTormenta() throws Lluvia {}
    public void eventoPartido() throws FutbolException {}
    public void diluvio() throws Lluvia {}
    void jugada() throws Mano{}

    public static void main (String[] args) {
        try {
            Encuentro enc = new Encuentro();
            enc.jugada();
        } catch(Mano e) {

        } catch(Lluvia e) {

        } catch(FutbolException e) {
            try {
                Partido par = new Encuentro();
                par.jugada();
            } catch(EquipoIncompleto ee) {

            } catch(Falta ee) {

            } catch(Lluvia ee) {

            } catch(FutbolException ee) {
            }
        }
        }
    }