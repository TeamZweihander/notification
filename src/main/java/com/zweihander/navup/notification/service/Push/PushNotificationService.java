package com.zweihander.navup.notification.service.Push;

/**
 * Created by George on 2017-05-12.
 */

import java.util.HashMap;
import java.util.Map;


import com.zweihander.navup.notification.service.exception.PushNotificationNotSentException;
import com.zweihander.navup.notification.service.request.SendPushNotificationRequest;
import com.zweihander.navup.notification.service.response.SendPushNotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import de.bytefish.fcmjava.http.client.IFcmClient;
import de.bytefish.fcmjava.model.enums.ErrorCodeEnum;
import de.bytefish.fcmjava.model.options.FcmMessageOptions;
import de.bytefish.fcmjava.model.topics.Topic;
import de.bytefish.fcmjava.requests.notification.NotificationPayload;
import de.bytefish.fcmjava.requests.topic.TopicUnicastMessage;
import de.bytefish.fcmjava.responses.TopicMessageResponse;

@Service
@Slf4j
public class PushNotificationService {

    private final RestTemplate restTemplate;

    private final IFcmClient fcmClient;

    private int id = 0;

    public PushNotificationService(IFcmClient fcmClient) {
        this.restTemplate = new RestTemplate();
        this.fcmClient = fcmClient;
    }

    public SendPushNotificationResponse sendPushNotification(SendPushNotificationRequest req) throws PushNotificationNotSentException
   {

       FcmMessageOptions options = FcmMessageOptions.builder().build();

        NotificationPayload payload = NotificationPayload.builder()
                .setBody("A new NavUP notifcation has arrived").setTitle("NavUP Notification")
                .setTag("notification").build();

        Map<String, Object> data = new HashMap<>();
        data.put("id", ++this.id);
        data.put("text", req.getMessage());

        // Send a message
        log.debug("Sending Notification...", req.getMessage());

        Topic topic = new Topic("NavUP_Notifications");
        TopicUnicastMessage message = new TopicUnicastMessage(options, topic, data, payload);

        TopicMessageResponse response = this.fcmClient.send(message);
        ErrorCodeEnum errorCode = response.getErrorCode();
        if (errorCode != null) {

            log.warn("NavUP notification sending failed:", errorCode);
           throw new  PushNotificationNotSentException();


        }

       return new SendPushNotificationResponse();
    }





}
