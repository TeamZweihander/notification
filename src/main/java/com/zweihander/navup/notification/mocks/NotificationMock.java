package com.zweihander.navup.notification.mocks;

import com.zweihander.navup.notification.service.Notification;
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
 * Created by Nsovo on 2017/03/28.
 */
public class NotificationMock implements Notification {

    @Override
    public SendNotificationResponse sendNotification(SendNotificationRequest req) throws NotificationNotSentException, EmailNotSentException{
        if(req == null)
            throw new NotificationNotSentException();
        else if(req.getType().equals("EMALL"))
            sendEmail(new SendEmailRequest("a@a.com", "test", "Test Message", false, false));
        else
            sendSMS(new SendSMSRequest());

        return new SendNotificationResponse();
    }

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException{

        return new SendEmailResponse();
    }

    @Override
    public SendSMSResponse sendSMS(SendSMSRequest req) throws NotificationNotSentException{
        return new SendSMSResponse();
    }
}
