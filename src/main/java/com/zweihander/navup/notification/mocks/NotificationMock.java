package com.zweihander.navup.notification.mocks;

import com.zweihander.navup.notification.service.Notification;
import com.zweihander.navup.notification.service.exception.*;
import com.zweihander.navup.notification.service.request.*;
import com.zweihander.navup.notification.service.response.*;


/**
 * Created by Nsovo on 2017/03/28.
 */
public class NotificationMock implements Notification {

   @Override
    public SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException{

        return new SendEmailResponse();
    }

    @Override
    public SendSMSResponse sendSMS(SendSMSRequest req) throws SMSNotSentException{
        return new SendSMSResponse();
    }
}
