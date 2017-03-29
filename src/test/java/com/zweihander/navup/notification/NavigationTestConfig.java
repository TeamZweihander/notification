package com.zweihander.navup.notification;

import com.zweihander.navup.notification.mocks.NotificationMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nsovo on 2017/03/29.
 */

@Configuration
public class NavigationTestConfig {
    @Bean
    public NotificationMock mock() {


        return new NotificationMock();
    }
}
