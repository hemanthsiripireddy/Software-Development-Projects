package com.hemanth.service;

import com.hemanth.model.*;
import com.hemanth.repository.NotificationRepo;
import com.hemanth.repository.UserRepo;
import com.hemanth.request.UserRequest;
import com.hemanth.response.PostResponse;

import java.util.List;

public class UserService {
private UserRepo userRepo;
    public boolean addUser(UserRequest userRequest){
        if(userRepo.containsUser(userRequest.getUserName())) return false;
       return userRepo.addUser(userRequest.getUser());
    }
    public boolean verifyCredentials(UserRequest userRequest){
       return userRepo.verifyPassword(userRequest.getUserName(),userRequest.getPassword());
    }

    public boolean closeAccount(int userId){
        return userRepo.deleteUser(userId);
        // activity, profile, feed,
    }
    public boolean updateName(int userId,String name){
        return userRepo.updateName(userId,name);
    }
    public boolean updateUserName(int userId,String userName){
        return userRepo.updateUserName(userId,userName);
    }
    public boolean updateMail(int userId,String mail)
    {
        return userRepo.updateMail(userId,mail);
    }
    public boolean updatePassword(int userId,String password){
        return userRepo.updatePassword(userId,password);

    }
    public boolean followAUser(int userId, int followingId){
        Profile myUser=userRepo.getUser(userId).getProfile();
        Profile followingUser=userRepo.getUser(followingId).getProfile();
        NotificationRepo notificationRepo=userRepo.getUser(followingId).getNotificationRepo();
        Notification notification=new Notification();
        notification.setType(NotificationType.newFollower);
        notification.setNewFollower(userId);
        notificationRepo.addNotification(notification);
        myUser.addFollowing(followingId);
        followingUser.addFollower(userId);
        return true;


    }
    public boolean unfollowAUser(int userId, int followingId){
        Profile myUser=userRepo.getUser(userId).getProfile();
        Profile followingUser=userRepo.getUser(followingId).getProfile();
        myUser.removeFollowing(followingId);
        followingUser.removeFollower(userId);
        return true;

    }
    public boolean removeFollower(int userId, int followerId){
        Profile myUser=userRepo.getUser(userId).getProfile();
        Profile followingUser=userRepo.getUser(followerId).getProfile();
        myUser.removeFollower(followerId);
        followingUser.removeFollowing(userId);
        return true;



    }
    public List<Notification> getMyNotifications(int userId){
        User user =userRepo.getUser(userId);
       NotificationRepo notificationRepo= user.getNotificationRepo();
      return notificationRepo.getNotifications();
    }

    public List<Activity> getActivity(int userId){
      return   userRepo.getUser(userId).getActivityRepo().getMyActivity();
    }

}
