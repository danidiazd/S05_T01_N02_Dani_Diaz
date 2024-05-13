package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FlorList.class)
    public ResponseEntity<String> handlerFlorList(FlorList msg) {
        return new ResponseEntity<>("ERROR: " + msg.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlorNoCreada.class)
    public ResponseEntity<String> handlerFlorNoCreada(FlorNoCreada msg) {
        return new ResponseEntity<>("ERROR: " + msg.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlorNoID.class)
    public ResponseEntity<String> handlerFlorNoID(FlorNoID msg) {
        return new ResponseEntity<>("ERROR: " + msg.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlorNula.class)
    public ResponseEntity<String> handlerFlorNula(FlorNula msg) {
        return new ResponseEntity<>("ERROR: " + msg.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
