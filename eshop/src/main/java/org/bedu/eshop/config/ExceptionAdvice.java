package org.bedu.eshop.config;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.bedu.eshop.dto.ErrorDTO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvice {

    // Este método se va ejecutar cuando se dectecten errores e validación 
    // es decir, cuando se lance excepciones de tipo MethodArgumentNotValidation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO validationError(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new LinkedList<>();

        //Extrayendo los mensajes de error directamente de la excepción
        for( FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getDefaultMessage());
        }
        return new ErrorDTO("ERROR_VALID", "Hubo en error al validar los datos de entrada", errors); 
    }

    
}
