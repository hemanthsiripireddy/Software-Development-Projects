package com.hemanth.EcomV2.apis;

import com.hemanth.EcomV2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartAPI {
    @Autowired
    CartService cartService;
@PostMapping("/add")
    public boolean add(@RequestParam  int userId, @RequestParam  int productId, @RequestParam  int quantity){
        return cartService.add(userId,productId,quantity);

       // return false;
    }
    @PostMapping("/remove")
    public boolean remove(@RequestParam int userId,@RequestParam int productId){
        return false;
    }
    @PostMapping("/update")
    public boolean updateQuantity(@RequestParam int userId,@RequestParam int productId,@RequestParam int quantity){
        return false;
    }
    public void getCart(int userid){
        return ;
    }
}
