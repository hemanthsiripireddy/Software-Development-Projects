package com.hemanth.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Interaction {
    private  int userId;
    private int toUserId;
    Map<Integer,Message> messages;
    int incId=0;

    public Message addMessage(int fromUserId,int toUserId,String message){
        Message msg=new Message(++incId,fromUserId,toUserId,message);
        messages.put(msg.getMessageId(),msg);
        return msg;
    }
    public boolean removeMessage(int messageId){
        return false;
    }

    public List<Message> getMyInteraction(){
        List<Message> list=new ArrayList<>();
        for(int key:messages.keySet()){
            list.add(messages.get(key));
        }
        return list;
    }
    public Message getMessage(int messageId){
      return  messages.get(messageId);
    }
}
