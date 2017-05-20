package com.zweihander.navup.notification.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED)
public class PushNotificationNotSentException extends Exception {

    private static final long serialVersionUID = -4369243337098740377L;

    public PushNotificationNotSentException() {
    }

    public PushNotificationNotSentException(String message) {
        super(message);
    }

    public PushNotificationNotSentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PushNotificationNotSentException(Throwable cause) {
        super(cause);
    }

    public PushNotificationNotSentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
