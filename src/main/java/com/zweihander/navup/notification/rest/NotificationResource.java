package com.zweihander.navup.notification.rest;

import com.zweihander.navup.notification.service.Notification;
import com.zweihander.navup.notification.service.request.*;
import com.zweihander.navup.notification.service.response.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification/api")
@Slf4j
public class NotificationResource {

    @Autowired
    private Notification notification;

    @RequestMapping(value = "/sendMessage",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody SendNotificationRequest req)  {
        log.debug("REST request to send Notifiction : {}", req);
        SendNotificationResponse res;
        try {
            res = notification.sendNotification(req);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
        return ResponseEntity.status(200).build();
    }
}
