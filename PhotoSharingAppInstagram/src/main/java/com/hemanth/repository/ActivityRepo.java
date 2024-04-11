package com.hemanth.repository;

import com.hemanth.model.Activity;
import com.hemanth.model.Comment;
import com.hemanth.model.Like;
import com.hemanth.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityRepo {
    private int userId;
    int incId=0;
   private Map<Integer, Activity> activityMap;


    public boolean addActivity(Activity activity){
        activityMap.put(++incId,activity);
        return true;
    }
    public boolean removeActivity(Comment comment){
        return false;
    }
    public List<Activity> getMyActivity(){
        List<Activity> myActivity=new ArrayList<>();
        for(int key:activityMap.keySet()){
            myActivity.add(activityMap.get(key));

        }

        return myActivity;
    }

}
