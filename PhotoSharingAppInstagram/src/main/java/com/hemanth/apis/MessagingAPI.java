package com.hemanth.apis;

import com.hemanth.model.Interaction;
import com.hemanth.model.Message;
import com.hemanth.model.User;
import com.hemanth.request.UserRequest;
import com.hemanth.service.MessagingService;

import java.util.List;

public class MessagingAPI {
    Authentication authentication;
    MessagingService service;

    public boolean message(UserRequest user, int toUserId, String message){

        if(authentication.login(user))
           return service.messageFriend(user.getId(),toUserId,message);

            return false;
    }
    public List<Message> getMyInteractionWithAGivenUser(UserRequest user, int toUserId){
        if(authentication.login(user)){
           return service.getMyInteractionWithMyFriend(user.getId(),toUserId);
        }
        return null;
    }
    public boolean deleteAMessage(UserRequest user,int toUserId, int messageId){
        if(authentication.login(user)){
            service.deleteMessage(user.getId(),toUserId,messageId);
        }
        return false;
    }
    public boolean deleteMyInteractionWihAGivenUser(UserRequest user,int toUserId){
        if(authentication.login(user)){
            return service.deleteMyInteractionWithMyFriend(user.getId(),toUserId);
        }
        return false;
    }
}
