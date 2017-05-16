package com.zweihander.navup.notification.config;

import lombok.Getter;
import org.apache.commons.codec.CharEncoding;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by Nsovo on 2017/04/06.
 */

@Getter
@ConfigurationProperties(prefix = "notification", ignoreUnknownFields = false)
public class NotificationConfig {

    public static final String ACCOUNT_SID = "AC153613b095b0d6854faedad5b5ffb38b";
    public static final String AUTH_TOKEN = "a343d704f896f29edaff2775ca4c9cd6";
    public static final String TWILIO_NUMBER = "+12564856376 ";

    private final CorsConfiguration cors = new CorsConfiguration();

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
