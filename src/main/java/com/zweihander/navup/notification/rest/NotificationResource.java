package com.zweihander.navup.rest;

import com.zweihander.navup.notification.Notification;
import com.zweihander.navup.notification.exception.*;
import com.zweihander.navup.notification.request.*;
import com.zweihander.navup.notification.response.SendNotificationResponse;
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
    public ResponseEntity<?> sendNotification(@RequestBody SendNotificationRequest req) throws NotificationNotSentException, EmailNotSentException {
        log.debug("REST request to send Notifiction : {}", req);
        SendNotificationResponse res = notification.sendNotification(req);
        return ResponseEntity.ok(res);
    }
    
}
