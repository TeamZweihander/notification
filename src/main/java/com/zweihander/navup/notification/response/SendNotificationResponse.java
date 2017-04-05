package com.zweihander.navup.notification.response;

import com.zweihander.navup.notification.EmailSender.Emailer;
import com.zweihander.navup.notification.NoticeType;
import com.zweihander.navup.notification.Response;
import com.zweihander.navup.notification.request.SendNotificationRequest;

/**
 * Created by George on 2017/04/04.
 */
public class SendNotificationResponse extends Response
{

    private NoticeType noticeType;


    public void sendNotificationResponse(SendNotificationRequest req)
    {
       noticeType=req.getNtype();


        switch (noticeType)
        {
            case EMAIL:
                Emailer em=new Emailer();
                em.sendEMail(req.getUser().getEmail(),"Confirmation Email",req.getMsg());

                break;

            case SMS:
                System.out.println("Not yet Implemented");
                break;

            default:
                break;

        }

    }



}
