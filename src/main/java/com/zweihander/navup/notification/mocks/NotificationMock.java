package com.zweihander.navup.notification.mocks;

import com.zweihander.navup.notification.Notification;
import com.zweihander.navup.notification.exception.NotificationNotSentException;
import com.zweihander.navup.notification.request.*;
import com.zweihander.navup.notification.response.*;

/**
 * Created by Nsovo on 2017/03/28.
 */
public class NotificationMock implements Notification {

    @Override
    public SendNotificationResponse sendNotification(SendNotificationRequest req) throws NotificationNotSentException{

        return null;
    }

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest req) throws NotificationNotSentException{

        return null;
    }

    @Override
    public SendSMSResponse sendSMS(SendSMSRequest req) throws NotificationNotSentException{
        return null;
    }
}
