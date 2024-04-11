package com.hemanth.apis;

import com.hemanth.model.Notification;
import com.hemanth.model.User;
import com.hemanth.request.UserRequest;
import com.hemanth.service.UserService;

import java.util.List;

public class NotificationAPI {
    // if someone followed me
    // if someone messaged me
    // if someone commented on my post
    // if someone liked my post
UserService service ;

    public List<Notification> myNewNotifications(UserRequest user){
   return service.getMyNotifications(user.getId());

    }
}
