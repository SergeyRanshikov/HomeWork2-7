package com.homework27.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class invalidInputExcetnion extends RuntimeException{
    public invalidInputExcetnion() {
    }

    public invalidInputExcetnion(String message) {
        super(message);
    }

    public invalidInputExcetnion(String message, Throwable cause) {
        super(message, cause);
    }

    public invalidInputExcetnion(Throwable cause) {
        super(cause);
    }

    public invalidInputExcetnion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
