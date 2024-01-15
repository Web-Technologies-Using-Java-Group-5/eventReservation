package com.univbuc.eventreservation.users.exceptions;

import com.univbuc.eventreservation.common.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class UserAlreadyLoggedInException extends BaseException {
    public UserAlreadyLoggedInException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
