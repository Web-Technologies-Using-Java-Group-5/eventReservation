package com.univbuc.eventreservation.admin.exceptions.handlers;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import com.univbuc.eventreservation.admin.exceptions.EventAlreadyRegistered;
import com.univbuc.eventreservation.common.exceptions.handlers.BaseExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AdminExceptionHandler extends BaseExceptionHandler {

    @ExceptionHandler(EventAlreadyRegistered.class)
    public ResponseEntity<Object> handleEventAlreadyRegistered(EventAlreadyRegistered ex, WebRequest request) {
        return buildResponse(ex, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new LinkedHashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
