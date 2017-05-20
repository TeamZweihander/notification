package com.zweihander.navup.notification.service.request;

import com.zweihander.navup.notification.Request;
import com.zweihander.navup.notification.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by George on 2017/05/10.
 */
@AllArgsConstructor
@Getter
@Setter
public class SendPushNotificationRequest extends Request{

   private String message;

}
