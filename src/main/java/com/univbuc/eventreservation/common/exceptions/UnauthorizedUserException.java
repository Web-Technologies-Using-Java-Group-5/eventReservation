package com.univbuc.eventreservation.common.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedUserException extends BaseException{
    public UnauthorizedUserException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
