package com.zweihander.navup.notification.domain;

/**
 *
 * @author Maria.Qumayo
 * @author George
 */


public class User {
   private String UserName;
   private String Password;
   private String email;
   private String phone;
   private int UserID;
           
  public User(String UserName, String Password, String em,String ph, int UserID){
      this.UserName = UserName;
      this.Password = Password;
      this.email=em;
      this.setPhone(ph);
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


    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}