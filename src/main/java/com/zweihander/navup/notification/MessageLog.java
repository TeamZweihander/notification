package com.zweihander.navup.notification;

import com.zweihander.navup.notification.request.SendNotificationRequest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by George on 2017-04-05.
 */
public class MessageLog
{

    public void logNotification(SendNotificationRequest req,String filename)
    {
        ObjectOutputStream out= null;
        try {
        out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(req);
    }
        catch (IOException e) {
        System.out.println("Problem occurred while logging");
    }



    }
}
