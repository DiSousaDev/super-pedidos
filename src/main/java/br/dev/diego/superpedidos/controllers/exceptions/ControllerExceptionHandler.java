package br.dev.diego.superpedidos.controllers.exceptions;

import br.dev.diego.superpedidos.services.exceptions.DataIntegrityException;
import br.dev.diego.superpedidos.services.exceptions.DatabaseNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DatabaseNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(DatabaseNotFoundException e, HttpServletRequest req) {
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setTitle("Database not found error.");
        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setDeveloperMessage(e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest req) {
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        err.setTitle("Database integrity error.");
        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setDeveloperMessage(e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
                                                                  HttpStatus st, WebRequest request) {

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationExceptionDetails err = new ValidationExceptionDetails();

        err.setTitle("Bad Request Exception, invalid fields");
        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setDeveloperMessage(e.getClass().getName());

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> err.addError(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(status).body(err);
    }
}
