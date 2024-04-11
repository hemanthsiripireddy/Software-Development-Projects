package com.hemanth.repository;

import com.hemanth.model.User;

import java.util.Map;

public class UserRepo {

    private Map<Integer, User> userRepoId;
    private Map<String, User> userRepoUserName;
    private int incId=0;


    public boolean deleteUser(int id){
        if(userRepoId.containsKey(id)){
            userRepoUserName.remove(userRepoId.get(id).getUserName());
            userRepoId.remove(id);
            return  true;
        }
        return false;
    }
    public boolean updatePassword(int id,String newPassword){
        if(userRepoId.containsKey(id)){
            userRepoId.get(id).setPassword(newPassword);
            return true;
        }
        return false;
    }
    public boolean updateMail(int id,String mail){
        if(userRepoId.containsKey(id)){
            userRepoId.get(id).setMail(mail);
            return true;
        }
        return false;
    }
    public boolean updateUserName(int id,String userName){
        if(userRepoId.containsKey(id)){
            userRepoId.get(id).setUserName(userName);
            return true;
        }
        return false;
    }
    public boolean updateName(int id,String name){
        if(userRepoId.containsKey(id)){
            userRepoId.get(id).setName(name);
            return true;
        }
        return false;
    }

    public boolean containsUser(int userId) {
        if(userRepoId.containsKey(userId))
            return true;
        return false;
    }
    public boolean addUser(User user){
        user.setUserId(++incId);
        userRepoId.put(user.getUserId(),user);
        userRepoUserName.put(user.getUserName(),user);
        return true;
    }

    public User getUser(int userId) {
        return userRepoId.get(userId);
    }
    public boolean containsUser(String userName){
       if( userRepoUserName.containsKey(userName) )return true;
        return false;
    }
    public boolean verifyPassword(String userName,String password){
        if(userRepoUserName.containsKey(userName)){
           return  userRepoUserName.get(userName).verifyMatch(password);

        }
        return false;
    }
}
