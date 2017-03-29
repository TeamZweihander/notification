package com.zweihander.navup.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * Created by Nsovo on 2017/03/29.
 */
@SpringBootApplication
public class NotificationApp {

    private static SpringApplication application = new SpringApplication(NotificationApp.class);

    public static void main(String[] args){
        //Environment env = application.run(args).getEnvironment();
        application.run(args);
    }

    public static void setApplication(SpringApplication application) {
        NotificationApp.application = application;
    }
}
