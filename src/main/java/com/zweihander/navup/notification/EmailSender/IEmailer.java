package com.zweihander.navup.notification.EmailSender;

import com.zweihander.navup.notification.exception.EmailNotSentException;

/**
 * Created by George on 2017-04-05.
 */
public interface IEmailer
{
    public boolean sendEMail( String recipient, String subject, String message) throws EmailNotSentException;


}
