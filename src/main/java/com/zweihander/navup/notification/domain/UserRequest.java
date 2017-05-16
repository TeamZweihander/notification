package com.zweihander.navup.notification.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Nsovo on 2017/05/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    private String username;

    public UserRequest() {

    }

    public UserRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
