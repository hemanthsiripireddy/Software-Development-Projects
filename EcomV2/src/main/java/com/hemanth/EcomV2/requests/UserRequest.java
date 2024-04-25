package com.hemanth.EcomV2.requests;

import com.hemanth.EcomV2.entity.User;
import com.hemanth.EcomV2.entity.UserType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String userName;
    private String password;
    private UserType userType;

    public UserRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User to(){
       return  User.builder().userName(userName).password(password).userType(userType).build();
    }
}
