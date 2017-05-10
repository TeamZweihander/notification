package com.zweihander.navup.notification.service.request;

import com.zweihander.navup.notification.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by George on 2017/04/04.
 */

public class SendNotificationRequest extends Request {
    private static final long serialVersionUID = -2461211078979515088L;

    private String type;
    private String username;
    private String subject;
    private String message;

    public SendNotificationRequest() {

    }

    public SendNotificationRequest(String type, String username, String subject, String message) {
        this.type = type;
        this.username = username;
        this.subject = subject;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
