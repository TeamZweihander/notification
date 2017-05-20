package com.zweihander.navup.notification.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Nsovo on 2017/05/10.
 */
@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED)
public class InvalidRequestException extends Exception {
    private static final long serialVersionUID = -654713123242632771L;

    public InvalidRequestException() {
    }

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestException(Throwable cause) {
        super(cause);
    }

    public InvalidRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
