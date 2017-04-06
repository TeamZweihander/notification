package com.zweihander.navup.notification;

import com.zweihander.navup.notification.exception.EmailNotSentException;
import com.zweihander.navup.notification.exception.NotificationNotSentException;
import com.zweihander.navup.notification.request.*;
import com.zweihander.navup.notification.response.*;

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
