package com.hemanth.EcomV2.apis;

import com.hemanth.EcomV2.entity.Address;
import com.hemanth.EcomV2.entity.User;
import com.hemanth.EcomV2.requests.UserRequest;
import com.hemanth.EcomV2.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAPI {
    @Autowired
    UserService userService;
    @GetMapping("")
    public String test(){
        return "Test API works";
    }
    @PostMapping("")
    public boolean register(@RequestBody UserRequest user){

       return userService.register(user.to());
    }
    @PostMapping("/login")

    public boolean login(@RequestBody UserRequest user){
        return userService.login(user);
    }
    @PostMapping("/updatePassword")
    public boolean updatePassword(@RequestBody UserRequest user,@RequestParam String newPassword){
    if(login(user))
      return   userService.updatePassword(user,newPassword);
    return false;
    }
  @PostMapping("/addAddress")
    public boolean addAddress(@RequestParam int user_id,@RequestBody Address address){
        return userService.addAddress(user_id,address);

    }
    @GetMapping("/get/address")
    public List<Address> getAddress(@RequestParam int user_id){
       return  userService.getAllAddresses(user_id);


    }
}
