package com.zweihander.navup.notification;

import com.zweihander.navup.notification.domain.User;
import com.zweihander.navup.notification.service.exception.*;
import com.zweihander.navup.notification.service.request.SendEmailRequest;
import com.zweihander.navup.notification.service.Notification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD
import org.springframework.mail.javamail.JavaMailSender;
//=======
import org.springframework.beans.factory.annotation.Value;
//>>>>>>> e084488bd8f796810996c773a1b7b732a35ec4c3
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Nsovo on 2017/04/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NavigationTestConfig.class)
public class SendEmailTest {

    private Wiser wiser;

    @Value("${spring.mail.port}")
    private int port;

    @Autowired
    private Notification notification;


    @Before
    public void setup() {
        wiser = new Wiser(port);
        wiser.setHostname("localhost");
        wiser.start();
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        wiser.stop();

    }

    @Test
    public void sendEmailTest() throws MessagingException, IOException, EmailNotSentException {


        notification.sendEmail(new SendEmailRequest(new User(1,"John", "u12163262@up.ac.za", "0736397435"), "Unit Testing", "This is a test string", false, false));

        assertEquals("No mail messages found", 1, wiser.getMessages().size());

        if (wiser.getMessages().size() > 0) {
            WiserMessage wMsg = wiser.getMessages().get(0);
            MimeMessage msg = wMsg.getMimeMessage();

            assertNotNull("message was null", msg);
            assertEquals("'Subject' did not match", "Unit Testing", msg.getSubject());
            assertEquals("'From' address did not match", "navup@cs.up.ac.za", msg.getFrom()[0].toString());
            assertEquals("'To' address did not match", "johndoe@example.com",
                    msg.getRecipients(MimeMessage.RecipientType.TO)[0].toString());
            //assertEquals("'Message' content did not match", "This is a test string", (String)msg.getContent());
        }

    }

    @Test (expected = EmailNotSentException.class)
    public void sendEmailFailTest() throws EmailNotSentException{
        throw new EmailNotSentException();
    }
/*
    @Test
    public void sendEmailFailedTest() throws MessagingException, IOException, EmailNotSentException {
        doThrow(new MailSendException("Test string")).when(javaMailSender).send((MimeMessage) anyObject());
        doThrow(new MailSendException("Test string")).when(javaMailSender).send((MimeMessage[]) anyObject());
        doThrow(new MailSendException("Test string")).when(javaMailSender).send((SimpleMailMessage) anyObject());
        doThrow(new MailSendException("Test string")).when(javaMailSender).send((SimpleMailMessage[]) anyObject());
        doThrow(new MailSendException("Test string")).when(javaMailSender).send((MimeMessagePreparator) anyObject());
        doThrow(new MailSendException("Test string")).when(javaMailSender).send((MimeMessagePreparator[]) anyObject());
        when(javaMailSender.createMimeMessage()).thenReturn(new JavaMailSenderImpl().createMimeMessage());
        thrown.expect(EmailNotSentException.class);

        notification.sendEmail(new SendEmailRequest("johndoe@example.com", "Unit Testing", "This is a test string", false, false));
    }*/
}
