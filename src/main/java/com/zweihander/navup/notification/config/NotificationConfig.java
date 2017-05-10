package com.zweihander.navup.notification.config;

import org.apache.commons.codec.CharEncoding;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by Nsovo on 2017/04/06.
 */

@ConfigurationProperties(prefix = "notification", ignoreUnknownFields = false)
public class NotificationConfig {

    public static final String ACCOUNT_SID = "AC945f948abd1a5742975ec6885fb41439";
    public static final String AUTH_TOKEN = "de654ca0d8a79e21cf2052e7a6fb22cf";
    public static final String TWILIO_NUMBER = "+12564856376 ";

    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("email_templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding(CharEncoding.UTF_8);
        templateResolver.setOrder(1);
        return templateResolver;
    }
}
