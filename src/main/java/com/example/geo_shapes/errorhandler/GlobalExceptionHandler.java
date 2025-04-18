package com.example.geo_shapes.errorhandler;

import com.example.geo_shapes.exception.InvalidShapeParameterException;
import com.example.geo_shapes.exception.ShapeInvalidTypeException;
import com.example.geo_shapes.exception.ShapeNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception{


    @ExceptionHandler(ShapeInvalidTypeException.class)
    public ResponseEntity<ErrorRespond> handleInvalidType(ShapeInvalidTypeException ex) {
        return new ResponseEntity<>(new ErrorRespond(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShapeNotFoundException.class)
    public ResponseEntity<ErrorRespond> handleNotFound(ShapeNotFoundException ex) {
        return new ResponseEntity<>(new ErrorRespond(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidShapeParameterException.class)
    public ResponseEntity<ErrorRespond> handleInvalidParams(InvalidShapeParameterException ex) {
        return new ResponseEntity<>(new ErrorRespond(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRespond> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return new ResponseEntity<>(new ErrorRespond(HttpStatus.BAD_REQUEST, errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorRespond> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        return new ResponseEntity<>(new ErrorRespond(HttpStatus.BAD_REQUEST, errorMessage), HttpStatus.BAD_REQUEST);
    }
}
