package com.example.ProjectSpringBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        // Aquí puedes agregar el mensaje personalizado
        String errorMessage = "Se ha producido un error: Uno o más campos están vacíos. Verifique los datos y vuelva a intentarlo.";

        // Respuesta personalizada en formato JSON
        return new ResponseEntity<>(new ErrorResponse("NullPointerException", errorMessage), HttpStatus.BAD_REQUEST);
    }

    // Puedes agregar otros métodos para manejar diferentes tipos de excepciones si es necesario
}

class ErrorResponse {
    private String error;
    private String mensaje;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.mensaje = message;
    }

    // Getters y setters
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
