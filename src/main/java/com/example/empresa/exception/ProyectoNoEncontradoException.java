package com.example.empresa.exception;

public class ProyectoNoEncontradoException extends RuntimeException {
    public ProyectoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
