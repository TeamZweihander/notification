package com.zweihander.navup.notification.rest;

import com.zweihander.navup.notification.domain.NotificationType;
import com.zweihander.navup.notification.domain.User;
import com.zweihander.navup.notification.service.Notification;
import com.zweihander.navup.notification.service.exception.*;
import com.zweihander.navup.notification.service.request.*;
import com.zweihander.navup.notification.service.exception.EmailNotSentException;
import com.zweihander.navup.notification.service.response.SendEmailResponse;
import com.zweihander.navup.notification.service.response.SendNotificationResponse;
import com.zweihander.navup.notification.service.request.SendNotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nsovo on 2017/04/05.
 */
@RestController
@RequestMapping("/service")
@Slf4j
public class NotificationResource {

    @Autowired
    Notification notification;

    @RequestMapping(value = "/sendNotification",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendEmail(@RequestBody SendEmailRequest req)  {
        log.debug("REST request to send Notifiction : {}", req);
        SendEmailResponse res;
        try {
            res = notification.sendEmail(req);
        }catch(EmailNotSentException ex){
            return ResponseEntity.badRequest().body(ex);
        }
        return ResponseEntity.status(200).build();
    }
}
