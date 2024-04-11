package com.hemanth.repository;

import com.hemanth.model.Interaction;
import com.hemanth.model.Message;
import com.hemanth.model.User;

import java.util.List;
import java.util.Map;

public class DirectMessageRepo {
   private User user;
   //here integer is my friend userid
   private Map<Integer, Interaction> interaction;

   public List<Message> getMyInteractionWithGivenUser(int myFriend){

      if(interaction.containsKey(myFriend)){
        return interaction.get(myFriend).getMyInteraction();
      }
      return null;
   }
   public boolean deleteAMessage(int myFriend,int messageId){
      if(interaction.containsKey(myFriend)){
         return interaction.get(myFriend).removeMessage(messageId);
      }
      return false;
   }
   public boolean deleteInteraction(int myFriend){
      if(interaction.containsKey(myFriend)){
          interaction.remove(myFriend);
          return true;
      }

      return false;
   }
   public Message messsageFriend(int fromUserId,int toUserId,String message){
      if(!interaction.containsKey(toUserId)){
        interaction.put(toUserId,new Interaction());
      }
     return interaction.get(toUserId).addMessage(fromUserId,toUserId,message);

      //return true;
   }
}
