package com.hemanth.model;

public class LightweightProfile {
    private int userId;
    private int numberOfFollowers;
    private  int numberOfFollowed;
    private int numberOfPosts;
    private String bio;
    private String userName;

    public LightweightProfile(int userId, int numberOfFollowers, int numberOfFollowed, int numberOfPosts, String bio, String userName) {
        this.userId = userId;
        this.numberOfFollowers = numberOfFollowers;
        this.numberOfFollowed = numberOfFollowed;
        this.numberOfPosts = numberOfPosts;
        this.bio = bio;
        this.userName = userName;
    }

    public LightweightProfile() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public int getNumberOfFollowed() {
        return numberOfFollowed;
    }

    public void setNumberOfFollowed(int numberOfFollowed) {
        this.numberOfFollowed = numberOfFollowed;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
