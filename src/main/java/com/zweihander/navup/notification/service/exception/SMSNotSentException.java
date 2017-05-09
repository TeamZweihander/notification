package com.zweihander.navup.notification.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED)
public class SMSNotSentException extends Exception {

    private static final long serialVersionUID = -4369243337098740377L;

    public SMSNotSentException() {
    }

    public SMSNotSentException(String message) {
        super(message);
    }

    public SMSNotSentException(String message, Throwable cause) {
        super(message, cause);
    }

    public SMSNotSentException(Throwable cause) {
        super(cause);
    }

    public SMSNotSentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
