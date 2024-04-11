package com.hemanth.apis;

import com.hemanth.model.Like;
import com.hemanth.model.User;
import com.hemanth.repository.UserRepo;
import com.hemanth.request.UserRequest;
import com.hemanth.response.UserResponse;
import com.hemanth.service.LikeService;

import java.util.List;

public class LikeAPostAPI {
    private LikeService likeService;
    private  Authentication authentication;

    public boolean likeAPost(UserRequest user, int postUserId, int postId){
        if(authentication.login(user)==false)
            return false;
        return likeService.likeAPost(user.getId(),postUserId,postId);
    }
    public boolean unlike(UserRequest user,int postUserId, int postId){
        if(authentication.login(user)==false)
            return false;
        return likeService.unlikeAPost(user.getId(),postUserId,postId);
    }

    public List<UserResponse> getLikes(UserRequest user, int postUserId, int postId){
        if(authentication.login(user)==false)
            return null;
        return likeService.getLikes(postUserId,postId);
    }
}
