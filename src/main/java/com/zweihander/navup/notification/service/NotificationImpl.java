package com.zweihander.navup.notification.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.zweihander.navup.notification.domain.User;
import com.zweihander.navup.notification.service.exception.*;
import com.zweihander.navup.notification.service.request.*;
import com.zweihander.navup.notification.service.response.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

import static com.zweihander.navup.notification.config.NotificationConfig.ACCOUNT_SID;
import static com.zweihander.navup.notification.config.NotificationConfig.AUTH_TOKEN;
import static com.zweihander.navup.notification.config.NotificationConfig.TWILIO_NUMBER;

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
    public SendNotificationResponse sendNotification(SendNotificationRequest req) throws InvalidRequestException, EmailNotSentException, SMSNotSentException{

        try{

            switch(req.getType()) {
                case "EMAIL":
                    sendEmail(new SendEmailRequest(new User(req.getUsername(), req.getUsername(), "+27736397435"), "NavUP: " + req.getSubject(), req.getMessage(), false, false));
                    break;
                case "SMS":
                    sendSMS(new SendSMSRequest(new User(req.getUsername(), req.getUsername(), "+27736397435"), "NavUP: " + req.getSubject() + "\r\n" + req.getMessage()));
                    break;
                default:
                    throw new InvalidRequestException();
            }

        }catch(EmailNotSentException ex){
            throw new EmailNotSentException();
        }catch(SMSNotSentException ex){
            throw new SMSNotSentException();
        }catch(Exception ex){
            throw new InvalidRequestException();
        }

        return new SendNotificationResponse();
    }

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest req) throws EmailNotSentException{

        log.debug("Sending e-mail to '{}'", req.getUser().getEmail());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, req.isMultipart(), CharEncoding.UTF_8);
            message.setTo(req.getUser().getEmail());
            message.setFrom("navup@cs.up.ac.za");
            message.setSubject(req.getSubject());
            message.setText(req.getMessage(), req.isHtml());
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to '{}'", req.getUser().getEmail());
        } catch (Exception e) {
            log.warn("Email could not be sent to user '{}'", req.getUser().getEmail());
            throw new  EmailNotSentException(e.getMessage());
        }
        return new SendEmailResponse();
    }

    @Override
    public SendSMSResponse sendSMS(SendSMSRequest req) throws SMSNotSentException{
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message;
        try {
            message = Message.creator(new PhoneNumber(req.getUser().getPhone()), //to
                            new PhoneNumber(TWILIO_NUMBER),  // from
                            req.getMessage())
                    .create();

            log.debug("Sent email to '{}'", message.getSid());
        }
        catch(Exception e){
            throw new SMSNotSentException();
        }

        return new SendSMSResponse();
    }
}
