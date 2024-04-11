package com.hemanth.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostResponse {
    private int postId;
    private int userId;
    private String contentLink;
    private String description;
    private List<String> hashtags;
    private List<Integer> taggedUsers;
    private int numberOfLikes;

    public PostResponse() {
    }

    public PostResponse(int postId, int userId, String contentLink, String description, int numberOfLikes) {
        this.postId = postId;
        this.userId = userId;
        this.contentLink = contentLink;
        this.description = description;
        this.numberOfLikes = numberOfLikes;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<String> hashtags) {
        this.hashtags = new ArrayList<>();
        for(String hashtag:hashtags){
            this.hashtags.add(hashtag);
        }
    }

    public List<Integer> getTaggedUsers() {
        return taggedUsers;
    }

    public void setTaggedUsers(Set<Integer> taggedUsers) {
        this.taggedUsers = new ArrayList<>();
        for(int userTag:taggedUsers){
            this.taggedUsers.add(userTag);
        }
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

}
