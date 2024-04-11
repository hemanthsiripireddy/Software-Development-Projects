package com.hemanth.service;

import com.hemanth.model.Message;
import com.hemanth.model.Notification;
import com.hemanth.model.NotificationType;
import com.hemanth.model.User;
import com.hemanth.repository.DirectMessageRepo;
import com.hemanth.repository.UserRepo;

import java.util.List;

public class MessagingService {
    DirectMessageRepo directMessageRepo;
    UserRepo userRepo;

    public boolean messageFriend(int fromUserId,int toUserId,String message){
        User fromUser=userRepo.getUser(fromUserId);
        User toUser=userRepo.getUser(toUserId);
       DirectMessageRepo fromUserMessageRepo=fromUser.getMessageRepo();
        DirectMessageRepo toUserMessageRepo=toUser.getMessageRepo();
        fromUserMessageRepo.messsageFriend(fromUserId,toUserId,message);
       Message msg= toUserMessageRepo.messsageFriend(fromUserId,toUserId,message);
        Notification notification=new Notification();
        notification.setType(NotificationType.newMessage);
        notification.setMessage(msg);
        notification.setDescription("user with userId "+fromUserId+" messaged you: ");
        toUser.getNotificationRepo().addNotification(notification);
        return true;


    }
    public boolean deleteMessage(int userId,int toUserId,int messageId){
        User fromUser=userRepo.getUser(userId);

        DirectMessageRepo fromUserMessageRepo=fromUser.getMessageRepo();

        fromUserMessageRepo.deleteAMessage(toUserId,messageId);

        return true;

    }
    public List<Message> getMyInteractionWithMyFriend(int userId,int toUserId){
        User fromUser=userRepo.getUser(userId);

        DirectMessageRepo fromUserMessageRepo=fromUser.getMessageRepo();

       return fromUserMessageRepo.getMyInteractionWithGivenUser(toUserId);



    }
    public boolean deleteMyInteractionWithMyFriend(int userId,int toUserId){
        User fromUser=userRepo.getUser(userId);

        DirectMessageRepo fromUserMessageRepo=fromUser.getMessageRepo();

        return fromUserMessageRepo.deleteInteraction(toUserId);



    }
}
