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
     * @param req
     * @return SendNotificationResponse
     * @throws InvalidRequestException
     * @throws EmailNotSentException
     * @throws SMSNotSentException
     */
    SendNotificationResponse sendNotification(SendNotificationRequest req) throws InvalidRequestException, EmailNotSentException, SMSNotSentException;

    /**
     *
     * @param req
     * @return SendEmailResponse
     * @throws EmailNotSentException
     */
    SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException;

    /**
     *
     * @param req
     * @return SendSMSResponse
     * @throws SMSNotSentException
     */
    SendSMSResponse sendSMS(SendSMSRequest req) throws SMSNotSentException;
}
