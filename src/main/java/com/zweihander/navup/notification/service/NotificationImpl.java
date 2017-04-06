package com.zweihander.navup.notification;

import com.zweihander.navup.notification.domain.NotificationType;
import com.zweihander.navup.notification.exception.EmailNotSentException;
import com.zweihander.navup.notification.exception.NotificationNotSentException;
import com.zweihander.navup.notification.request.*;
import com.zweihander.navup.notification.response.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

/**
 * Created by Nsovo on 2017/03/28.
 */
@Service
@Slf4j
public class NotificationImpl implements Notification {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public SendNotificationResponse sendNotification(SendNotificationRequest req) throws NotificationNotSentException, EmailNotSentException {
        if(req == null)
            throw  new NotificationNotSentException();
        else if(req.getType() == NotificationType.EMAIL)
            sendEmail(new SendEmailRequest(req.getUser().getEmail(), "Email", req.getMessage(), false, false));

        return new SendNotificationResponse();
    }

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException{

        log.debug("Sending e-mail to '{}'", req.getTo());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, req.isMultipart(), CharEncoding.UTF_8);
            message.setTo(req.getTo());
            message.setFrom("navup@cs.up.ac.za");
            message.setSubject(req.getSubject());
            message.setText(req.getMessage(), req.isHtml());
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to '{}'", req.getTo());
        } catch (Exception e) {
            log.warn("Email could not be sent to user '{}'", req.getTo());
            throw new  EmailNotSentException(e.getMessage());
        }
        return new SendEmailResponse();
    }

    @Override
    public SendSMSResponse sendSMS(SendSMSRequest req) throws NotificationNotSentException{
        return null;
    }



}
