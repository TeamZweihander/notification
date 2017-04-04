package com.zweihander.navup.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Nsovo on 2017/03/29.
 */
@Getter
@ConfigurationProperties(prefix = "notification", ignoreUnknownFields = false)
public class NotificationProperties{

    @Getter
    @Setter
    public static class Mail {

        private String from = "navup@cs.up.ac.za";
    }
}
