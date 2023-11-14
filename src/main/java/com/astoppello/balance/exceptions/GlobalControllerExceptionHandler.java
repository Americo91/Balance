package com.astoppello.balance.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity handleException(TransactionSystemException e) {
        ResponseEntity.BodyBuilder responseEntity = ResponseEntity.badRequest();

        if (e.getCause().getCause() instanceof ConstraintViolationException) {
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause().getCause();

            List<Map<String, String>> error = ve.getConstraintViolations().stream().map(constraintViolation -> {
                Map<String, String> errMap = new HashMap<>();
                errMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
                return errMap;
            }).toList();
            return responseEntity.body(error);
        }
        return responseEntity.build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBindErrors(MethodArgumentNotValidException exception) {
        List<Map<String, String>> errorList = exception.getFieldErrors().stream().map(fieldError -> {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            return errorMap;
        }).toList();
        return ResponseEntity.badRequest().body(errorList);
    }


}
