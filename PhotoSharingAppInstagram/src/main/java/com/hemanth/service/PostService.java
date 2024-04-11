package com.hemanth.service;

import com.hemanth.model.Post;
import com.hemanth.model.User;
import com.hemanth.repository.PostRepo;
import com.hemanth.repository.UserRepo;
import com.hemanth.request.PostRequest;

public class PostService {

   private UserRepo userRepo;
   private FeedService feedService;

   public boolean addPost(int userId, PostRequest postRequest){
       if(userRepo.containsUser(userId)){
           User user=userRepo.getUser(userId);
           PostRepo postRepo=user.getPostRepo();
            Post post=postRequest.getPost();
            post.setUser(userId);
            feedService.pushToMyFollowers(userId,post);
           return postRepo.addPost(post);
       }

       return false;

   }

    public  boolean removePost(int userId,int postId){
       if(userRepo.containsUser(userId)){
           User user=userRepo.getUser(userId);
           PostRepo postRepo=user.getPostRepo();
           return postRepo.removePost(postId);
       }
       return false;
    }
    public boolean updateDescription(int userId,int postId,String description){
        if(userRepo.containsUser(userId)){
            User user=userRepo.getUser(userId);
            PostRepo postRepo=user.getPostRepo();
            return postRepo.updateDescription(postId,description);
        }
        return false;

    }
    public boolean addHashtag(int userId,int postId,String hashtag){
        if(userRepo.containsUser(userId)){
            User user=userRepo.getUser(userId);
            PostRepo postRepo=user.getPostRepo();
            return postRepo.addHashtag(postId,hashtag);
        }
        return false;
    }
    public boolean removeHashtag(int userId,int postId,String hashtag){
        if(userRepo.containsUser(userId)){
            User user=userRepo.getUser(userId);
            PostRepo postRepo=user.getPostRepo();
            return postRepo.removeHashtag(postId,hashtag);
        }
        return false;
    }
    public boolean tagUser(int userId,int postId,int tagUserId){
        if(userRepo.containsUser(userId)){
            User user=userRepo.getUser(userId);
            PostRepo postRepo=user.getPostRepo();
            return postRepo.addTaggedUser(postId,tagUserId);
        }
        return false;
    }
    public boolean untagUser(int userId,int postId,int tagUserId){
        if(userRepo.containsUser(userId)){
            User user=userRepo.getUser(userId);
            PostRepo postRepo=user.getPostRepo();
            return postRepo.removeTaggedUser(postId,tagUserId);
        }
        return false;
    }
}
