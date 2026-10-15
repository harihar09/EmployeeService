package com.EmployeeService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMisMatch(MethodArgumentTypeMismatchException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "bad requst",
                        "message", "Invalid value for parameter " + ex.getName()));

    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, String>> noResourceFound(NoResourceFoundException ex) {

        return ResponseEntity.status(404)
                .body(Map.of("error", "bad request",
                        "message", "Invalid request, no resource found " + ex.getMessage()));
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, String>> employeeNotFound(EmployeeNotFoundException ex){
         return ResponseEntity.status(HttpStatus.NOT_FOUND)
                 .body(Map.of("error","not found. "+ex.getMessage(),
                         "message","employee not found with give id"));
    }
}
