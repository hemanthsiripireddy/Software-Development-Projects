package com.hemanth.apis;

import com.hemanth.model.Activity;
import com.hemanth.model.User;
import com.hemanth.model.UserActivity;
import com.hemanth.request.UserRequest;
import com.hemanth.service.UserService;

import java.util.List;

public class UserActivityAPI {
    UserService service;
    Authentication authentication;
    public List<Activity> getUserActivity(UserRequest user){
        if(authentication.login(user))
       return  service.getActivity(user.getId());
        return null;

    }
}
