package org.example.apis;

import org.example.models.Admin;
import org.example.models.Customer;
import org.example.models.User;
import org.example.services.UserManagement;

public class SignUp {
    UserManagement userManagement;
    public boolean singUp(String first, String last, String userName,String password){
        User user;
        if(userName.equals("admin"))
                user=new Admin().setUserName(userName).setPassword(password);
        user=new Customer().setUserName(userName).setPassword(password);

        boolean res=userManagement.singUp(user);
        if(res) {
            return  true;
        }else{
           return  false;
        }
    }

    public SignUp() {
        userManagement=UserManagement.getInstance();
    }
}
