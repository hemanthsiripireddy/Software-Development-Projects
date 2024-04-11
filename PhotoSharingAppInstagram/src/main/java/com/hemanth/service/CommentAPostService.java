package com.hemanth.service;

import com.hemanth.model.*;
import com.hemanth.repository.ActivityRepo;
import com.hemanth.repository.NotificationRepo;
import com.hemanth.repository.PostRepo;
import com.hemanth.repository.UserRepo;

import java.util.List;

public class CommentAPostService {
    UserRepo userRepo;
    public boolean comment(int userId,int userPostId,int postId,String comment){
        User user=userRepo.getUser(userPostId);
        PostRepo postRepo=user.getPostRepo();
        Post post=postRepo.getPost(postId);

         Comment cmt= post.comment(userId,comment);
        if(cmt!=null){
            Notification notification=new Notification();
            notification.setType(NotificationType.newComment);
//            Like like=new Like();
//            like.setPostId(postId);
//            like.setUserPostId(postUserId);
//            like.setUserId(userId);
            notification.setComment(cmt);
            notification.setDescription("user id: "+user+" commented your post with postId "+postId);
            NotificationRepo notificationRepo=userRepo.getUser(userPostId).getNotificationRepo();
            notificationRepo.addNotification(notification);
            Activity activity=new Activity();
            activity.setType(ActivityType.Comment);
            activity.setComment(cmt);
            ActivityRepo activityRepo=userRepo.getUser(userId).getActivityRepo();
            activityRepo.addActivity(activity);
            return true;
        }
        return false;


    }
    public boolean updateComment(int userPostId,int postId,int commentId,String comment){
        User user=userRepo.getUser(userPostId);
        PostRepo postRepo=user.getPostRepo();
        Post post=postRepo.getPost(postId);
        return post.updateComment(commentId,comment);

    }
    public boolean deleteComment(int userPostId,int postId,int commentId){
        User user=userRepo.getUser(userPostId);
        PostRepo postRepo=user.getPostRepo();
        Post post=postRepo.getPost(postId);
        return post.deleteComment(commentId);

    }
    public List<Comment> getAllComments(int userPostId,int postId){
        User user=userRepo.getUser(userPostId);
        PostRepo postRepo=user.getPostRepo();
        Post post=postRepo.getPost(postId);
        return post.getComments();

    }

}
