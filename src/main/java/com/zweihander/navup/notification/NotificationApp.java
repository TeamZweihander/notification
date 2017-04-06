package com.zweihander.navup.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by Nsovo on 2017/03/29.
 */
@SpringBootApplication
@Slf4j
public class NotificationApp {

    private static SpringApplication application = new SpringApplication(NotificationApp.class);

    public static void main(String[] args){
        //Environment env = application.run(args).getEnvironment();
        application.run("--debug");
    }

    public static void setApplication(SpringApplication application) {
        NotificationApp.application = application;
    }
}