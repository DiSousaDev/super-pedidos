package br.dev.diego.superpedidos.services.exceptions;

public class DatabaseNotFoundException extends RuntimeException {

    public DatabaseNotFoundException(String message) {
        super(message);
    }

}
