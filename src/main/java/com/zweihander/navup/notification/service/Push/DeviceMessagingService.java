package com.zweihander.navup.notification.service.Push;

/**
 * Created by George on 2017-05-12.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.zweihander.navup.notification.service.exception.PushNotificationNotSentException;
import com.zweihander.navup.notification.service.request.SendPushNotificationRequest;
import com.zweihander.navup.notification.service.response.SendPushNotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import de.bytefish.fcmjava.http.client.IFcmClient;
import de.bytefish.fcmjava.model.options.FcmMessageOptions;
import de.bytefish.fcmjava.requests.data.DataUnicastMessage;
import de.bytefish.fcmjava.requests.notification.NotificationPayload;
import de.bytefish.fcmjava.responses.FcmMessageResponse;
import de.bytefish.fcmjava.responses.FcmMessageResultItem;

@Service
@Slf4j
public class DeviceMessagingService {

    private final Set<String> tokenRegistry = new CopyOnWriteArraySet<>();

    private final IFcmClient fcmClient;

    private int id = 0;

    public DeviceMessagingService(IFcmClient fcmClient) {
        this.fcmClient = fcmClient;
    }

    public void addToken(String token) {
        this.tokenRegistry.add(token);
    }

    public void removeToken(String token) {
        this.tokenRegistry.remove(token);
    }

    public SendPushNotificationResponse sendPushNotification(SendPushNotificationRequest req) throws PushNotificationNotSentException
    {
        FcmMessageOptions options = FcmMessageOptions.builder().build();

        NotificationPayload payload = NotificationPayload.builder()
                .setBody("A Personal Message").setTitle("Personal Message").setTag("personal")
                .build();

        for (String token : this.tokenRegistry) {
             log.debug("Sending personal message to:", token);

            Map<String, Object> data = new HashMap<>();
            data.put("id", ++this.id);
            data.put("text",req.getMessage());

            DataUnicastMessage message = new DataUnicastMessage(options, token, data, payload);
            FcmMessageResponse response = this.fcmClient.send(message);
            for (FcmMessageResultItem result : response.getResults()) {
                if (result.getErrorCode() != null) {
                   log.warn("NavUP notification sending to "+token+" failed:",  result.getErrorCode());
                    throw new  PushNotificationNotSentException();
                }
            }
        }
        return new SendPushNotificationResponse();
    }

}
