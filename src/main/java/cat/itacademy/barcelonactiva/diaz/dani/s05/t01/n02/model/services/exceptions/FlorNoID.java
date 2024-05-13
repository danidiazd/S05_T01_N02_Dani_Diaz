package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions;

public class FlorNoID extends RuntimeException {

    public FlorNoID(Integer id) {
        super("No se ha encontrado la flor con ID " + id);
    }
}
