package com.hemanth.request;

import com.hemanth.model.Post;

import java.util.Set;

public class PostRequest {

    private String contentLink;
    private String description;
    private Set<String> hashtags;
    private Set<Integer> taggedUsers;

    public PostRequest(String contentLink, String description, Set<String> hashtags, Set<Integer> taggedUsers) {
        this.contentLink = contentLink;
        this.description = description;
        this.hashtags = hashtags;
        this.taggedUsers = taggedUsers;
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

    public Set<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<String> hashtags) {
        this.hashtags = hashtags;
    }

    public Set<Integer> getTaggedUsers() {
        return taggedUsers;
    }

    public void setTaggedUsers(Set<Integer> taggedUsers) {
        this.taggedUsers = taggedUsers;
    }

    public Post getPost(){
        Post post=new Post();
        post.setDescription(this.description);
        post.setContentLink(this.contentLink);
        post.setHashtags(this.hashtags);
        post.setTaggedUsers(this.taggedUsers);
        return post;

    }
}
