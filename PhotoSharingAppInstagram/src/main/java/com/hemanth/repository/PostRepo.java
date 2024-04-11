package com.hemanth.repository;

import com.hemanth.model.Post;
import com.hemanth.response.PostResponse;
import com.hemanth.service.PostService;

import java.util.*;

public class PostRepo {

    int userId;
    int postIdInc=0;
    private Map<Integer, Post> posts;
    private Map<String, Set<Integer>> hastagPosts;


    public boolean removePost(int postId){
        if(posts.containsKey(postId)){
            for(String hashtag:posts.get(postId).getHashtags()){
                hastagPosts.get(hashtag).remove(postId);
            }
            posts.remove(postId);

            return true;
        }

        return false;

    }
    public boolean addPost(Post post){
        post.setPostId(++postIdInc);
        for(String hashtag:post.getHashtags()){
            hastagPosts.put(hashtag,hastagPosts.getOrDefault(hashtag,new HashSet<>()));
            hastagPosts.get(hashtag).add(post.getPostId());
        }
        posts.put(post.getPostId(),post);

        return false;
    }
    public boolean updateDescription(int postId, String description){
        if(posts.containsKey(postId)){
            posts.get(postId).setDescription(description);
            return true;
        }

        return false;

    }
    public boolean addHashtag(int postId, String hashtag){
        if(posts.containsKey(postId)){
            hastagPosts.get(hashtag).add(postId);
            posts.get(postId).addHashtag(hashtag);
            return true;
        }

        return false;

    }
    public boolean removeHashtag(int postId,String hashtag){
        if(posts.containsKey(postId)){
            hastagPosts.get(hashtag).remove(postId);
           return  posts.get(postId).removeHashtag(hashtag);

        }

        return false;

    }
    public boolean addTaggedUser(int postId, int userId){
        if(posts.containsKey(postId)){
            posts.get(postId).tagUser(userId);
            return true;
        }

        return false;

    }
    public boolean removeTaggedUser(int postId,int userId){
        if(posts.containsKey(postId)){
            return  posts.get(postId).removeTag(userId);

        }

        return false;

    }
    public Post getPost(int postId){
        if(posts.containsKey(postId))
            return posts.get(postId);
        return null;
    }
    public int getSize(){
        return posts.size();
    }
    public List<PostResponse> getLightWeightPosts(){
        List<PostResponse> responses=new ArrayList<>();
        for(int key:posts.keySet()){
            Post post=posts.get(key);
            PostResponse postResponse=new PostResponse(post.getPostId(),post.getUserId(),post.getContentLink(),post.getDescription(),post.getLikes().size());
            postResponse.setHashtags(post.getHashtags());
            postResponse.setTaggedUsers(post.getTaggedUsers());
            responses.add(postResponse);


        }
        return responses;

    }
    public List<PostResponse> getPostsByHashtag(String hashtag){
        if(hastagPosts.containsKey(hashtag)){
            List<PostResponse> responses=new ArrayList<>();
            Set<Integer> postIds=hastagPosts.get(hashtag);
            for(int key:postIds){

                Post post=posts.get(key);
                PostResponse postResponse=new PostResponse(post.getPostId(),post.getUserId(),post.getContentLink(),post.getDescription(),post.getLikes().size());
                postResponse.setHashtags(post.getHashtags());
                postResponse.setTaggedUsers(post.getTaggedUsers());
                responses.add(postResponse);

            }
            return responses;

        }
        return null;
    }
}
