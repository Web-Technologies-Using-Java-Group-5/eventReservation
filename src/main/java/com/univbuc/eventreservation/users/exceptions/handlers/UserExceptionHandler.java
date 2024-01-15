package com.univbuc.eventreservation.users.exceptions.handlers;

import com.univbuc.eventreservation.common.exceptions.UserNotLoggedInException;
import com.univbuc.eventreservation.common.exceptions.handlers.BaseExceptionHandler;
import com.univbuc.eventreservation.users.exceptions.InvalidCredentialsException;
import com.univbuc.eventreservation.users.exceptions.UserAlreadyLoggedInException;
import com.univbuc.eventreservation.users.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Object> handleInvalidCredentials(InvalidCredentialsException ex, WebRequest request) {
        return buildResponse(ex, request);
    }

    @ExceptionHandler(UserAlreadyLoggedInException.class)
    public ResponseEntity<Object> handleUserAlreadyLoggedIn(UserNotLoggedInException ex, WebRequest request) {
        return buildResponse(ex, request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex, WebRequest request) {
        return buildResponse(ex, request);
    }
}
