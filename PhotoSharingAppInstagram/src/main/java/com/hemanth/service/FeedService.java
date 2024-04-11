package com.hemanth.service;

import com.hemanth.model.Post;
import com.hemanth.model.User;
import com.hemanth.repository.UserRepo;
import com.hemanth.response.PostResponse;

import java.util.ArrayList;
import java.util.List;

public class FeedService {
private UserRepo userRepo;
    public boolean pushToMyFollowers(int userId, Post post) {
        List<Integer>userIds=userRepo.getUser(userId).getProfile().getFollowers();
       for(int id:userIds){
           User user=userRepo.getUser(id);
           user.getFeed().addPostToFeed(post);
       }
       return true;

    }
    public List<PostResponse> getFeed(int userId){
      List<Post> posts=  userRepo.getUser(userId).getFeed().getFeed();
      List<PostResponse> res=new ArrayList<>();
      for(Post post: posts){
          res.add(post.getPostResponse());
      }
      return res;
    }


}
