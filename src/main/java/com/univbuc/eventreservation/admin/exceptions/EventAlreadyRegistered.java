package com.univbuc.eventreservation.admin.exceptions;

import com.univbuc.eventreservation.common.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class EventAlreadyRegistered extends BaseException {
    public EventAlreadyRegistered(String message) {
        super(message, HttpStatus.FOUND);
    }
}
