package com.hemanth.apis;

import com.hemanth.model.User;
import com.hemanth.request.UserRequest;
import com.hemanth.service.UserService;

public class FollowAndUnfollowAPI {
    Authentication authentication;
    UserService userService;

    public boolean follow(UserRequest user, int followedId){
        if(authentication.login(user))
          return  userService.followAUser(user.getId(),followedId);

        return false;
    }
    public boolean unfollow(UserRequest user,int followedId){
        if(authentication.login(user))
          return  userService.unfollowAUser(user.getId(),followedId);
        return false;
    }
    public boolean removeFollower(UserRequest user,int followerId){
        if(authentication.login(user))
            return userService.removeFollower(user.getId(),followerId);

        return false;
    }
}
