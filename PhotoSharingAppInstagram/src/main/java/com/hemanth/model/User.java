package com.hemanth.model;

import com.hemanth.repository.ActivityRepo;
import com.hemanth.repository.DirectMessageRepo;
import com.hemanth.repository.NotificationRepo;
import com.hemanth.repository.PostRepo;
import com.hemanth.response.UserResponse;

public class User {
    private int userId;
    private Profile profile;

    private DirectMessageRepo messageRepo;
    private ActivityRepo activityRepo;
    private Feed feed;
    private NotificationRepo notificationRepo;

  //  private String userName;
    private String password;
    private String mail;
    // String name;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public DirectMessageRepo getMessageRepo() {
        return messageRepo;
    }

    public void setMessageRepo(DirectMessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public ActivityRepo getActivityRepo() {
        return activityRepo;
    }

    public void setActivityRepo(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    public User() {
    }

    public User(int userId, String userName, String password, String mail, String name) {
        this.userId = userId;
       profile.setUserName(userName);
        this.password = password;
        this.mail = mail;
        profile.setName(name);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return profile.getUserName();
    }

    public void setUserName(String userName) {
        profile.setUserName(userName) ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return profile.getName();
    }

    public void setName(String name) {
        profile.setName( name);
    }

    public PostRepo getPostRepo() {
       return  profile.getPostRepo();
    }
    public boolean verifyMatch(String password){
        if(this.password.equals(password)) return true;
        return false;

    }

    public NotificationRepo getNotificationRepo() {
        return notificationRepo;
    }

    public void setNotificationRepo(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    public UserResponse getUserResponse(){
       return  new UserResponse(userId, profile.getUserName());
    }

}
