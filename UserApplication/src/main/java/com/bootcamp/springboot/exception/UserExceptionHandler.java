package com.bootcamp.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    //Throw Exception when the user don't indicate name or birthdate

    @ExceptionHandler(value = {UserPersistException.class})
    public ResponseEntity<Object> persistUserHandler(UserPersistException exception) {
        //1. Creo el cuerpo de la excepcion que se mostrara en caso de ocurrir el error
        HttpStatus status = HttpStatus.BAD_REQUEST;
        UserException userException = new UserException(exception.getClass(), "Error en la persistencia de datos", status.value(), exception.getMessage());
        //2. Retorno la excepcion
        return new ResponseEntity<>(userException, status);
    }

    @ExceptionHandler(value = {UserRequestException.class})
    public ResponseEntity<Object> defaultUserHandler(UserRequestException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        UserException defaultException = new UserException(exception.getClass(), "Unexpected error", status.value(), exception.getMessage());
        return new ResponseEntity<>(defaultException, status);
    }
}
