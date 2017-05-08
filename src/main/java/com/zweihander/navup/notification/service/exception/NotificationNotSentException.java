package com.zweihander.navup.notification.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED)
public class NotificationNotSentException extends Exception {

    private static final long serialVersionUID = -4369243337098740377L;

    public NotificationNotSentException() {
    }

    public NotificationNotSentException(String message) {
        super(message);
    }

    public NotificationNotSentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationNotSentException(Throwable cause) {
        super(cause);
    }

    public NotificationNotSentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
