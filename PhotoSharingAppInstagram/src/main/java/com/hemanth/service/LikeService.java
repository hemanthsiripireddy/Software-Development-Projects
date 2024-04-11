package com.hemanth.service;

import com.hemanth.model.*;
import com.hemanth.repository.ActivityRepo;
import com.hemanth.repository.NotificationRepo;
import com.hemanth.repository.UserRepo;
import com.hemanth.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class LikeService {
    UserRepo userRepo;

    public boolean likeAPost(int userId,int postUserId,int postId){
        User user=userRepo.getUser(postUserId);
        boolean res =user.getProfile().getPostRepo().getPost(postId).likePost(userId);
        if(res){
            Like like=new Like();
            like.setPostId(postId);
            like.setUserPostId(postUserId);
            like.setUserId(userId);
            Notification notification=new Notification();
            notification.setType(NotificationType.newLike);

            notification.setLike(like);
            notification.setDescription("user id: "+like.getUserId()+" liked your post with postId "+postId);
            NotificationRepo notificationRepo=userRepo.getUser(postUserId).getNotificationRepo();
            notificationRepo.addNotification(notification);

            Activity activity=new Activity();
            activity.setType(ActivityType.Like);
            activity.setLike(like);
            ActivityRepo activityRepo=userRepo.getUser(userId).getActivityRepo();
            activityRepo.addActivity(activity);

            return true;
        }
        return false;

    }
    public boolean unlikeAPost(int userId,int postUserId,int postId){
        User user=userRepo.getUser(postUserId);
        return user.getProfile().getPostRepo().getPost(postId).unlike(userId);

    }
    public List<UserResponse> getLikes(int postUserId, int postId){
        User user=userRepo.getUser(postUserId);
        List<Integer> userIds= user.getProfile().getPostRepo().getPost(postId).getLikes();
        List<UserResponse> res=new ArrayList<>();
        for(int id:userIds){
             user=userRepo.getUser(id);
             res.add(user.getUserResponse());
        }
        return res;

    }
}
