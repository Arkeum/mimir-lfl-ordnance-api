package fr.dpeynot.mimir.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> Default(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> ResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> DuplicateResourceException(DuplicateResourceException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
