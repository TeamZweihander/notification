package com.zweihander.navup.notification.request;

import com.zweihander.navup.notification.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Nsovo on 2017/03/28.
 */
@Getter
@AllArgsConstructor
public class SendNotificationRequest extends Request{

    long userid;
    String message;
    String type;
}
