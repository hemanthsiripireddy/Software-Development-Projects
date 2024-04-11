package com.hemanth.service;

import com.hemanth.model.LightweightProfile;
import com.hemanth.model.Like;
import com.hemanth.model.User;
import com.hemanth.repository.UserRepo;
import com.hemanth.response.PostResponse;
import com.hemanth.response.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProfileService {
    UserRepo userRepo;

    public LightweightProfile getProfile(int userId){
        User user=userRepo.getUser(userId);
       return user.getProfile().getLightWeightProfile();

    }

    public List<UserResponse> getFollowers(int userId){
        List<UserResponse>  res=new ArrayList<>();
        List<Integer> followers=userRepo.getUser(userId).getProfile().getFollowers();
        for(int id:followers){
           UserResponse response= userRepo.getUser(userId).getUserResponse();
           res.add(response);
        }
        return  res;

    }
    public List<UserResponse> getFollowing(int userId){
        List<UserResponse>  res=new ArrayList<>();
        List<Integer> followers=userRepo.getUser(userId).getProfile().getFollowing();
        for(int id:followers){
            UserResponse response= userRepo.getUser(userId).getUserResponse();
            res.add(response);
        }
        return  res;

    }
    public boolean updateBio(int userid,String bio){
        userRepo.getUser(userid).getProfile().setBio(bio);
        return true;

    }
    public boolean updatePhoto(int userId, String photo){
         userRepo.getUser(userId).getProfile().setUserPhotoLink(photo);
         return true;



    }
    public List<PostResponse> getPost(int userId){
        return userRepo.getUser(userId).getProfile().getPostRepo().getLightWeightPosts();
    }
}
