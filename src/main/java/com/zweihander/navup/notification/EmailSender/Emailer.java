package com.zweihander.navup.notification.EmailSender;

import com.zweihander.navup.notification.exception.EmailNotSentException;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


/**
 * Implementation of the IEmailer which is used to send an email to a user.
 * Makes use of JavaMail API
 *
 *  Created by George on 2017-04-05.
 */

public class Emailer implements IEmailer
{
    private String sender; //The email address of the sender.

    protected Properties properties; //The properties of the environment

    protected Session session; //A mail session that provides access to the protocol providers that implement the Store, Transport, and related classes.

    protected String host; //The server that hosts the sender address


    public Emailer()
    {
        sender = "Zweihander.Notification@NavUP";
        host = "localhost";
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        Session session = Session.getDefaultInstance(properties); //get default properties


    }

    @Override
    public boolean sendEMail(String recipient, String subject, String message)
    {

        try {
            // Create a default MimeMessage object.
            MimeMessage msg = new MimeMessage(session);

            // Set From: header field of the header.
            msg.setFrom(new InternetAddress(sender));

            // Set To: header field of the header.
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: header field
            msg.setSubject(subject);

            // Now set the actual message
            msg.setText(message);

            // Send message
            Transport.send(msg);

            System.out.println("Message sent successfully....");
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return false;
    }


}
