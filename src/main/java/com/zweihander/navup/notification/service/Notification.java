package com.zweihander.navup.notification.service;

import com.zweihander.navup.notification.service.exception.EmailNotSentException;
import com.zweihander.navup.notification.service.exception.NotificationNotSentException;
import com.zweihander.navup.notification.service.request.*;
import com.zweihander.navup.notification.service.response.*;
import com.zweihander.navup.notification.service.request.SendEmailRequest;
import com.zweihander.navup.notification.service.request.SendNotificationRequest;
import com.zweihander.navup.notification.service.request.SendSMSRequest;
import com.zweihander.navup.notification.service.response.SendEmailResponse;
import com.zweihander.navup.notification.service.response.SendNotificationResponse;
import com.zweihander.navup.notification.service.response.SendSMSResponse;

/**
 *
 */
public interface Notification {
    /**
     *
     * @param req
     * @return
     * @throws NotificationNotSentException
     */
    SendNotificationResponse sendNotification(SendNotificationRequest req) throws NotificationNotSentException, EmailNotSentException;

    /**
     *
     * @param req
     * @return
     * @throws NotificationNotSentException
     */
    SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException;

    /**
     *
     * @param req
     * @return
     * @throws NotificationNotSentException
     */
    SendSMSResponse sendSMS(SendSMSRequest req) throws NotificationNotSentException;
}
