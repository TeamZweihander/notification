package com.zweihander.navup.notification.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED)
public class EmailNotSentException extends Exception {

       public EmailNotSentException() {
           super();
    }

    public EmailNotSentException(String message) {
        super(message);
    }

    public EmailNotSentException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNotSentException(Throwable cause) {
        super(cause);
    }

    public EmailNotSentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
