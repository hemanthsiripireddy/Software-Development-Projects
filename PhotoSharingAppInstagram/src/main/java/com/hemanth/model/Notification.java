package com.hemanth.model;

public class Notification {

    private int id;
    NotificationType type;
    private Like like;
   private  Comment comment;
   private  int  newFollowerId;
   private Message message;

   private String description;

    public Notification(int id, NotificationType type, Like like, Comment comment, User newFollower, String description) {
        this.id = id;
        this.type = type;
        this.like = like;
        this.comment = comment;
        this.newFollower = newFollower;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Like getLike() {
        return like;
    }

    public void setLike(Like like) {
        this.like = like;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getNewFollower() {
        return newFollowerId;
    }

    public void setNewFollower(int newFollower) {
        this.newFollowerId = newFollower;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Notification() {
    }
}
