package com.hemanth.EcomV2.service;

import com.hemanth.EcomV2.entity.Cart;
import com.hemanth.EcomV2.entity.Product;
import com.hemanth.EcomV2.repository.CartRepo;
import com.hemanth.EcomV2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
@Autowired
    private ProductRepo productRepo;
@Autowired
    private CartRepo cartRepo;

    public boolean add(int userId,int productId,int quantity){

        Product product=productRepo.getById(productId);

        Cart cart=cartRepo.findByUserId(userId);
        boolean res= cart.add(product,quantity);
        cartRepo.save(cart);
        return res;



    }
}
