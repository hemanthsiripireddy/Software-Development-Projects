package com.hemanth.apis;

import com.hemanth.model.Post;
import com.hemanth.model.User;
import com.hemanth.response.PostResponse;
import com.hemanth.service.FeedService;

import java.util.List;

public class FeedAPI {
    private FeedService feedService;
    public List<PostResponse> getUserFeed(int userId){
        return feedService.getFeed(userId);

    }
}
