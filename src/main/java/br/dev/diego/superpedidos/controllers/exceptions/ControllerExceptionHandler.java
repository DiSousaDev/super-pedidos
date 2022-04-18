package br.dev.diego.superpedidos.controllers.exceptions;

import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DatabaseNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(DatabaseNotFoundException e, HttpServletRequest req) {
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setStatus(status.value());
        err.setMsg(e.getMessage());
        err.setTimeStamp(Instant.now());

        return ResponseEntity.status(status).body(err);
    }

}
