package com.hemanth.apis;

import com.hemanth.model.User;
import com.hemanth.request.UserRequest;
import com.hemanth.service.UserService;

public class Authentication {
    private UserService userService;

    public boolean signup(UserRequest user){
        return userService.addUser(user);

    }
    public boolean login(UserRequest user){

     return    userService.verifyCredentials(user);
    }
    public boolean closeAccount(UserRequest user){
        if(login(user))
      return   userService.closeAccount(user.getId());
        return false;


    }

    public boolean updateName(UserRequest user,String newName){
        if(login(user))
        return userService.updateName(user.getId(),newName);
        return false;


    }
    public boolean updateUserName(UserRequest user,String newUserName){
        if(login(user))
        return userService.updateUserName(user.getId(),newUserName);
        return false;
    }
    public boolean updateMail(UserRequest user,String newMail){
        if(login(user))
        return userService.updateMail(user.getId(),newMail);
        return false;
    }
    public boolean updatePassword(UserRequest user,String password){
        if(login(user))

        return userService.updatePassword(user.getId(),password);
        return false;
    }
}
