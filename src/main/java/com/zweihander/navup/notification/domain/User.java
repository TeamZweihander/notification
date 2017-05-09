package com.zweihander.navup.notification.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Maria.Qumayo
 * @author George
 */
@AllArgsConstructor
@Getter
@Setter
public class User {
   private int UserID;
   private String name;
   private String email;
   private String phone;
}