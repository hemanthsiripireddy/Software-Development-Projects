package com.hemanth.EcomV2.service;

import com.hemanth.EcomV2.entity.Address;
import com.hemanth.EcomV2.entity.Cart;
import com.hemanth.EcomV2.entity.User;
import com.hemanth.EcomV2.entity.WishList;
import com.hemanth.EcomV2.repository.AddressRepo;
import com.hemanth.EcomV2.repository.CartRepo;
import com.hemanth.EcomV2.repository.UserRepo;
import com.hemanth.EcomV2.repository.WishListRepo;
import com.hemanth.EcomV2.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    WishListRepo wishListRepo;

    @Autowired
    AddressRepo addressRepo;

    public boolean register(User user){

        WishList wishList=new WishList();
        Cart cart=new Cart();
        user.setCart(cart);
        user.setWishList(wishList);
        cartRepo.save(cart);
        wishListRepo.save(wishList);
        userRepo.save(user);
        return true;

    }
    public boolean login(UserRequest userRequest){
        User user=userRepo.findByUserName(userRequest.getUserName());
        if(user!=null&&user.getPassword().equals(userRequest.getPassword()))
            return true;
        return false;
    }

    public boolean updatePassword(UserRequest userRequest,String password){
        User user=userRepo.findByUserName(userRequest.getUserName());
        if(user!=null){
            user.setPassword(password);
            userRepo.save(user);
            return true;
        }
        return true;
    }
    public boolean addAddress(int userId,Address address){
        User user=userRepo.getById(userId);
       boolean res= user.addAddress(address);
      // address.setUser(user);
      // address.s
      //addressRepo.save(address);
       userRepo.save(user);
       return true;



    }
    public List<Address> getAllAddresses(int userId){
        User user=userRepo.getById(userId);
        return user.getAddresses();

    }
}
