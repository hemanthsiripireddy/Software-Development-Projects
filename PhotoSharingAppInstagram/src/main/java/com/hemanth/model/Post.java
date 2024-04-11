package com.hemanth.model;

import com.hemanth.response.PostResponse;
import com.hemanth.service.PostService;

import java.util.*;

public class Post {

    private int postId;
    private int userId;
    private String contentLink;
    private String description;
    private Set<String> hashtags;
    private Set<Integer> taggedUsers;
    //here integer is userId
    int likeIdInc=0;
    int commentIdInc=0;
    //here integer is userId
    private Set<Integer>likes;
    //here integer is comment id;
    private Map<Integer,Comment> comments;

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addHashtag(String hashtag){
        hashtags.add(hashtag);
    }
    public boolean removeHashtag(String hashtag){
        if(hashtags.contains(hashtag)){
            hashtags.remove(hashtag);
            return true;
        }
        return false;
    }
    public boolean removeTag(int userId){
        if(taggedUsers.contains(userId))
        {
            taggedUsers.remove(userId);
            return false;
        }
        return false;

    }
    public void tagUser(int userId){
        taggedUsers.add(userId);
    }

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Set<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<String> hashtags) {
        this.hashtags = new HashSet<>();
        for(String hashtag: hashtags){
            this.hashtags.add(hashtag);
        }
    }

    public Set<Integer> getTaggedUsers() {
        return taggedUsers;
    }

    public void setTaggedUsers(Set<Integer> taggedUsers) {
        this.taggedUsers = new HashSet<>();
        for(int userTag:taggedUsers){
            this.taggedUsers.add(userTag);
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }

    public PostResponse getPostResponse(){
        PostResponse postResponse=new PostResponse();
        postResponse.setContentLink(this.contentLink);
        postResponse.setDescription(this.description);
        postResponse.setHashtags(hashtags);
        postResponse.setTaggedUsers(taggedUsers);
        postResponse.setPostId(postId);
        postResponse.setUserId(userId);
        postResponse.setNumberOfLikes(likes.size());
        return postResponse;
    }
    public boolean likePost(int id){
        if(likes.add(id)) {

            return true;
        }
        return false;
    }
    public  boolean unlike(int id){
        if(likes.contains(id)){
            likes.remove(id);
            return true;

        }
        return false;
    }
    public List<Integer> getLikes(){
        List<Integer> res=new ArrayList<>();
        for(int id:likes){
            res.add(id);
        }
        return res;

    }

    public Comment comment(int userId, String comment){
        Comment cmt=new Comment(++commentIdInc,this.postId,userId,comment);

        comments.put(cmt.getId(),cmt);
        return cmt;

    }
    public boolean updateComment(int commentId,String comment){
        Comment cmt=comments.getOrDefault(commentId,null);
        if(cmt==null) return false;
        if(cmt.getUserId()==userId){
            cmt.setComment(comment);
            return true;
        }
        return false;
    }
    public boolean deleteComment(int commentId){
        Comment cmt=comments.getOrDefault(commentId,null);
        if(cmt==null) return false;
        if(cmt.getUserId()==userId){
            comments.remove(commentId);
            return true;
        }
        return false;

    }
    public List<Comment> getComments(){
        List<Comment> list=new ArrayList<>();
        for(int key:comments.keySet()){
            list.add(comments.get(key));
        }
        return list;
    }

    public String getContentLink() {
        return contentLink;
    }

    public String getDescription() {
        return description;
    }
}
