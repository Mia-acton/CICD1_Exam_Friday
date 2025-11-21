package com.example.cic1_lab_exam;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Errors> handleValidationExceptions(MethodArgumentNotValidException mae) {
        List<Errors> errorList = new ArrayList<>();
        mae.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = error.getObjectName();
            String errorMessage = error.getDefaultMessage();
            Errors errors = new Errors(fieldName, errorMessage);
            errorList.add(errors);
        });
        return errorList;
    }
}
