package com.devnic.pezeshasimplemoneytransfersystem.exceptionHandling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseBody> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseBody(ex.getMessage(), ex.getCause()));
    }

    @ExceptionHandler(ResourceTakenException.class)
    public ResponseEntity<ExceptionResponseBody>  handleResourceTakenException(ResourceTakenException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponseBody(ex.getMessage(), ex.getCause()));
    }
  @ExceptionHandler(NegativeEvaluationException.class)
    public ResponseEntity<ExceptionResponseBody>  handleNegativeEvaluationException(NegativeEvaluationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseBody(ex.getMessage(), ex.getCause()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String errorMessage = violation.getMessage();
            errors.put("message", errorMessage);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
