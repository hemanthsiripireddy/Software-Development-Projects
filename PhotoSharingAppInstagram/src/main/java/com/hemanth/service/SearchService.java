package com.hemanth.service;

import com.hemanth.repository.PostRepo;
import com.hemanth.response.PostResponse;

import java.util.List;

public class SearchService {
    PostRepo postRepo;
    public List<PostResponse> getPostsByHashtag(String hashtag){
       return postRepo.getPostsByHashtag(hashtag);

    }
}
