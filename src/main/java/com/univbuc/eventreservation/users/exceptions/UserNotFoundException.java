package com.univbuc.eventreservation.users.exceptions;

import com.univbuc.eventreservation.common.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
