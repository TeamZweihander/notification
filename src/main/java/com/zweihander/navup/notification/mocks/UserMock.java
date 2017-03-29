/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zweihander.navup.notification.mocks;

/**
 *
 * @author Maria.Qumayo
 */
public class UserMock {
   private String UserName;
   private String Password;
   private int UserID;
           
  public UserMock(String UserName, String Password, int UserID){
      this.UserName = UserName;
      this.Password = Password;		
      this.UserID = UserID;		
   }
  
  public int getUserId() {
      return UserID;
   }
  
public void setUserId(int userId) {
      this.UserID = userId;
   }

public String getUserName() {
      return UserName;
   }
  
public void setUserName(String userName) {
      this.UserName = userName;
    }
}