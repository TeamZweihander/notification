package com.zweihander.navup.notification.service;

import com.zweihander.navup.notification.service.exception.EmailNotSentException;
import com.zweihander.navup.notification.service.exception.*;
import com.zweihander.navup.notification.service.request.*;
import com.zweihander.navup.notification.service.response.*;

/**
 *
 */
public interface Notification {

    /**
     *
     * @param req
     * @return
     * @throws EmailNotSentException
     */
    SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException;

    /**
     *
     * @param req
     * @return
     * @throws SMSNotSentException
     */
    SendSMSResponse sendSMS(SendSMSRequest req) throws SMSNotSentException;
}
