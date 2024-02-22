package org.example.apis;
import org.example.apis.admin.AdminPage;
import org.example.apis.user.UserPage;
import org.example.models.Admin;
import org.example.models.Customer;
import org.example.models.User;
import org.example.services.UserManagement;

public class Login {
  UserManagement userManagement;
    public Page login(String userName,String password){
        User res=userManagement.login(userName,password);
        if(res==null){
            System.out.println("Login fialed");
            return null;
        }
        else{
            if(res.getUserName().equals("admin"))

            return  new AdminPage(res);
            return new UserPage(res);


        }

    }
    public Login(){
        userManagement=UserManagement.getInstance();
    }
}
