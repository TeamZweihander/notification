package com.zweihander.navup.notification;

import com.zweihander.navup.notification.config.NotificationConfig;
import com.zweihander.navup.notification.service.Notification;
import com.zweihander.navup.notification.service.NotificationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by Nsovo on 2017/03/29.
 */

@Configuration
@Import({
        MailSenderAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class,
        ThymeleafAutoConfiguration.class})
@EnableConfigurationProperties({ NotificationConfig.class })
public class NavigationTestConfig {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }
    @Bean
    public Notification notification(){
        return new NotificationImpl();
    }

    @Bean
    public JavaMailSender javaMailSender(){
        return  new JavaMailSenderImpl();
    }
}
