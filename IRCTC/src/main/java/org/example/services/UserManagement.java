package org.example.services;

import org.example.models.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;
import java.util.Map;

 public class UserManagement {
    Map<String ,User> users=new HashMap<>();

    private  static UserManagement userManagement;
    public  static UserManagement getInstance(){
        if(userManagement==null)
            userManagement=new UserManagement();
        return  userManagement;
    }

    public UserManagement() {
        users=new HashMap<>();
    }

    public boolean singUp(User user){
        String userName=user.getUserName();
        if(users.containsKey(userName))
            return false;
        users.put(user.getUserName(),user);
        return true;

    }
    public User login(String userName,String password){
        if(users.containsKey(userName))
        {
            if(users.get(userName).getPassword().equals(password))
                return users.get(userName);
            return null;
        }
        return null;

    }
    public boolean updatePassword(String userName,String oldPassword,String newPassword){
        if(users.containsKey(userName))
        {
            if(users.get(userName).getPassword().equals(oldPassword)){
                 users.get(userName).setPassword(newPassword);
                 return true;

            }

            return false;
        }
        return false;

    }
}
