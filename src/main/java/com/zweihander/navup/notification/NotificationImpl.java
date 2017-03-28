package com.zweihander.navup.notification;

import com.zweihander.navup.notification.exception.NotificationNotSentException;
import com.zweihander.navup.notification.request.*;
import com.zweihander.navup.notification.response.*;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
/**
 * Created by Nsovo on 2017/03/28.
 */
@Service
public class NotificationImpl implements Notification {

    @Inject
    private JavaMailSender javaMailSender;

    @Inject
    private MessageSource messageSource;

    @Override
    public SendNotificationResponse sendNotification(SendNotificationRequest req) throws NotificationNotSentException {

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
