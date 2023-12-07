package com.univbuc.eventreservation.common.exceptions;

import org.springframework.http.HttpStatus;

public class DatabaseError extends BaseException {
    public DatabaseError(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
