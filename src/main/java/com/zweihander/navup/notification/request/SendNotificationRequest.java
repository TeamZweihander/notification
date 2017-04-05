package com.zweihander.navup.notification.request;

import com.zweihander.navup.notification.NoticeType;
import com.zweihander.navup.notification.Request;
import com.zweihander.navup.notification.UserMock;

/**
 * Created by George on 2017/04/04.
 */

public class SendNotificationRequest extends Request
{
   private NoticeType ntype;
   private UserMock user;
   private String msg;

   public  SendNotificationRequest(NoticeType type,UserMock usr, String msg )
    {
      this.user=usr;
      this.ntype=type;
      this.msg=msg;

    }


    public NoticeType getNtype() {
        return ntype;
    }

    public UserMock getUser() {
        return user;
    }

    public String getMsg() {
        return msg;
    }



}
