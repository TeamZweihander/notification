package com.zweihander.navup.notification.request;

import com.zweihander.navup.notification.Request;
import com.zweihander.navup.notification.domain.NotificationType;
import com.zweihander.navup.notification.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Created by George on 2017/04/04.
 */
@AllArgsConstructor
@Getter
public class SendNotificationRequest extends Request {
    private static final long serialVersionUID = -2461211078979515088L;
    private NotificationType type;
    private User user;
    private String message;
}
