package com.univbuc.eventreservation.events.exceptions;

import com.univbuc.eventreservation.common.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class EventSoldOutException extends BaseException {
    public EventSoldOutException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
