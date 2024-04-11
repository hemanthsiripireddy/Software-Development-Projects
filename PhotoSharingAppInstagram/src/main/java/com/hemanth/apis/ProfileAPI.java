package com.hemanth.apis;

import com.hemanth.model.LightweightProfile;
import com.hemanth.model.Post;
import com.hemanth.model.User;
import com.hemanth.request.UserRequest;
import com.hemanth.response.PostResponse;
import com.hemanth.response.UserResponse;
import com.hemanth.service.ProfileService;

import java.util.List;

public class ProfileAPI {
ProfileService profileService;
Authentication authentication;
    public List<UserResponse> getFollowers(UserRequest user){
        if(authentication.login(user))
         return   profileService.getFollowers(user.getId());
        return null;
    }
    public List<UserResponse> getFollowed(UserRequest user){
        if(authentication.login(user))
            profileService.getFollowing(user.getId());
        return null;
    }
    public LightweightProfile getProfile(UserRequest user){
        if(authentication.login(user))
          return   profileService.getProfile(user.getId());

        return null;
    }
    public List<PostResponse> getPosts(UserRequest user,int userPostId){
        if(authentication.login(user))
            return profileService.getPost(userPostId);

        return null;
    }
    public boolean editPhoto(UserRequest user,String newPhoto){
        if(authentication.login(user))
            return profileService.updatePhoto(user.getId(),newPhoto);
        return false;
    }
    public boolean editBio(UserRequest user, String newBio){
        if(authentication.login(user))
           return profileService.updateBio(user.getId(),newBio);
        return false;
    }

}
