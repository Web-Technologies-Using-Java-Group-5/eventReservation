package com.univbuc.eventreservation.common.exceptions;

import org.springframework.http.HttpStatus;

public class EventNotFoundException extends BaseException{
    public EventNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
