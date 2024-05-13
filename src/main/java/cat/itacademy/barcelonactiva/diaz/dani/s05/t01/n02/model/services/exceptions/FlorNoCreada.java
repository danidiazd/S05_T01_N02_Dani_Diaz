package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions;

public class FlorNoCreada extends RuntimeException {

    public FlorNoCreada() {
        super("No se ha podido crear la flor");
    }
}
