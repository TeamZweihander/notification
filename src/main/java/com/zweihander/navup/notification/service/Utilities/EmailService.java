package com.zweihander.navup.notification.service.Utilities;

import com.zweihander.navup.notification.service.exception.EmailNotSentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * Created by George on 2017-05-01.
 */

@Service
@Slf4j
public class EmailService {

    private JavaMailSender mailSender;

    private EmailContentBuilderService emailContentBuilder;

    @Autowired
    public EmailService(JavaMailSender mailSender, EmailContentBuilderService mailContentBuilder) {
        this.mailSender = mailSender;
        this.emailContentBuilder = mailContentBuilder;
    }

    public void SendEmail(String recipient, String message) throws EmailNotSentException {

        log.debug("Sending e-mail to '{}'", recipient);

           MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("navup@cs.up.ac.za");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Notification Module Test");
            String content = emailContentBuilder.build(message);
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
            log.debug("Sent email to '{}'", recipient);
        } catch (Exception e) {
            // runtime exception; compiler will not force you to handle it
            log.warn("Email could not be sent to user '{}'", recipient);

            throw new EmailNotSentException(e.getMessage());
        }
    }
}
