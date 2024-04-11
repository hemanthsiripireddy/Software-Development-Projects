package com.hemanth.repository;

import com.hemanth.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationRepo {

    private  int userId;
    List<Notification> notifications;

    public List<Notification> getNotifications(){
       List<Notification> notifications1=notifications;
       notifications=null;
       return notifications1;

    }
    public boolean addNotification(Notification notification){
        if(notifications==null)
            notifications=new ArrayList<>();
        notifications.add(notification);
        return true;
    }
}
