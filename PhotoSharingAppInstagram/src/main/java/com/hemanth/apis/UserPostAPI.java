package com.hemanth.apis;

import com.hemanth.model.Post;
import com.hemanth.model.User;
import com.hemanth.request.PostRequest;
import com.hemanth.request.UserRequest;
import com.hemanth.service.PostService;

public class UserPostAPI {
    private Authentication authentication;
    private PostService postService;

    public boolean addNewPost(UserRequest user, PostRequest post){
        if(authentication.login(user)==false)
            return false;
       return  postService.addPost(user.getId(),post);



    }
    public boolean updateDescription(UserRequest user, int postId,String description){
        if(authentication.login(user)==false)
            return false;

        return postService.updateDescription(user.getId(),postId,description);
    }
    public boolean addHashtag(UserRequest user,int postId,String hashtag ){
        if(authentication.login(user)==false)
            return false;
        return postService.addHashtag(user.getId(),postId,hashtag);
    }

    public boolean tagUser(UserRequest user,int postId,int tagUserId){

        if(authentication.login(user)==false)
            return false;
        return postService.tagUser(user.getId(),postId,tagUserId);
    }
    public boolean removeHashtag(UserRequest user, int postId,String hashtag){

        if(authentication.login(user)==false)
            return false;
        return postService.removeHashtag(user.getId(),postId,hashtag);
    }
    public boolean untagUser(UserRequest user,int postId,int tagUserId ){
        if(authentication.login(user)==false)
            return false;
        return postService.untagUser(user.getId(),postId,tagUserId);
    }
    public boolean deletePost(UserRequest user,int postId){

        if(authentication.login(user)==false)
            return false;
        return postService.removePost(user.getId(),postId);
    }
}
