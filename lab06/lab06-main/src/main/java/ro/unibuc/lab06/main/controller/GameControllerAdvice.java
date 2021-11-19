package ro.unibuc.lab06.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ro.unibuc.lab06.main.dto.ErrorResponse;
import ro.unibuc.lab06.main.exception.TooManyGamesException;

@ControllerAdvice
public class GameControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        final var firstError = ex.getAllErrors().get(0);
        final var response = firstError instanceof FieldError fe
                ? new ErrorResponse(fe.getField(), fe.getDefaultMessage())
                : new ErrorResponse(firstError.getDefaultMessage());
        return ResponseEntity.status(400).body(response);
    }

    @ExceptionHandler(TooManyGamesException.class)
    public ResponseEntity<ErrorResponse> handleTooManyGames(TooManyGamesException ex) {
        return ResponseEntity.status(429).body(new ErrorResponse(ex.getMessage()));
    }

}
