package com.hemanth.apis;

import com.hemanth.model.Comment;
import com.hemanth.model.User;
import com.hemanth.request.UserRequest;
import com.hemanth.service.CommentAPostService;

import java.util.List;

public class CommentAPostAPI {
    CommentAPostService commentAPostService;
    Authentication authentication;

    public boolean comment(UserRequest user, int postUserId, int postId, String comment){
        if(authentication.login(user))
          return  commentAPostService.comment(user.getId(),postUserId,postId,comment);
        return false;
    }
    public boolean updateComment(UserRequest user,int postUserId,int postId,int commentId,String comment){
        if(authentication.login(user))
          return  commentAPostService.updateComment(postUserId,postId,commentId,comment);
        return false;
    }

    public boolean deleteComment(UserRequest user,int postUserId,int postId, int commentId){
        if(authentication.login(user))
           return commentAPostService.deleteComment(postUserId,postId,commentId);
        return false;
    }
    public List<Comment> getComments(UserRequest user, int postUserId, int postId){
        if(authentication.login(user))
           return commentAPostService.getAllComments(postUserId,postId);
        return null;
    }
}
