package com.hemanth.model;

import com.hemanth.repository.PostRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Profile {
    private User user;
    private String userPhotoLink;

    private String bio;
    private String name;
    private String userName;

 private Set<Integer> followers;
   private Set<Integer> following;
   private PostRepo postRepo;


    public PostRepo getPostRepo() {
        return postRepo;
    }

    public List<Integer> getFollowers() {
        List<Integer> res=new ArrayList<>();
        for(int id:followers){
            res.add(id);
        }
        return res;
    }



    public List<Integer> getFollowing() {
        List<Integer> res=new ArrayList<>();
        for(int id:following){
            res.add(id);
        }
        return res;
    }
    public boolean addFollower(int userId){
        followers.add(userId);
        return true;
    }
    public boolean removeFollower(int userId){
        followers.remove(userId);
        return true;
    }
    public boolean addFollowing(int userId){
        following.add(userId);
        return true;
    }
    public boolean removeFollowing(int userId){
        following.remove(userId);
        return true;
    }



    public void setPostRepo(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public String getUserPhotoLink() {
        return userPhotoLink;
    }

    public void setUserPhotoLink(String userPhotoLink) {
        this.userPhotoLink = userPhotoLink;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LightweightProfile getLightWeightProfile(){
        LightweightProfile profile=new LightweightProfile();
        profile.setBio(bio);
        profile.setNumberOfFollowers(followers.size());
        profile.setNumberOfPosts(postRepo.getSize());
        profile.setNumberOfFollowed(following.size());
        profile.setUserName(userName);
        return profile;


    }
}
