package com.hemanth.model;

import com.hemanth.repository.ActivityRepo;

import java.util.*;

public class Feed {
    private  int userId;
    private  int feedIdInc=0;
    Map<Integer,Post> feedMap;


    public Feed(int userId) {
        this.userId = userId;
        feedMap=new LinkedHashMap<>();
    }
    public boolean addPostToFeed(Post post){
        feedMap.put(++feedIdInc,post);
        if(feedMap.size()>50){
           int dif=feedMap.size()-50;
            Set<Integer> keys = feedMap.keySet();

           while(dif>0){
               Integer firstKey = keys.iterator().next();
               feedMap.remove(firstKey);
               dif--;

           }
        }
        return true;

    }
    public List<Post> getFeed(){
        Set<Integer> keys = feedMap.keySet();
        List<Post>res=new ArrayList<>();
        Iterator iterator= keys.iterator();
        while(iterator.hasNext()){
            res.add(feedMap.get(iterator.next()));
        }
        Collections.reverse(res);
        return res;

    }
}
