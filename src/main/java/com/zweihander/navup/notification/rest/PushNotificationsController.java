package com.zweihander.navup.notification.rest;

/**
 * Created by George on 2017-05-16.
 */
import com.zweihander.navup.notification.service.Push.DeviceMessagingService;
import com.zweihander.navup.notification.service.Push.PushNotificationService;
import com.zweihander.navup.notification.service.exception.PushNotificationNotSentException;
import com.zweihander.navup.notification.service.request.SendPushNotificationRequest;
import com.zweihander.navup.notification.service.response.SendPushNotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PushNotification")
@Slf4j
public class PushNotificationsController {

    @Autowired
    private DeviceMessagingService devicesender;

    @Autowired
    private PushNotificationService topicsender;



    @RequestMapping(value = "/subscribe",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void subscribe(@RequestParam("token") String token)
    {
        log.debug("register:", token);
        this.devicesender.addToken(token);
    }

    @RequestMapping(value = "/unsubscribe",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void unsubscribe(@RequestParam("token") String token) {
        System.out.println("unregister: " + token);
        this.devicesender.removeToken(token);
    }

    @RequestMapping(value = "/sendPushNotification",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendPushNotification(@RequestBody SendPushNotificationRequest req)  {
        log.debug("REST request to send Push Notifiction : {}", req);
        SendPushNotificationResponse res;
        try {
            res = topicsender.sendPushNotification(req);
        }catch(PushNotificationNotSentException ex){
            return ResponseEntity.badRequest().body(ex);
        }
        return ResponseEntity.status(200).build();
    }
}



