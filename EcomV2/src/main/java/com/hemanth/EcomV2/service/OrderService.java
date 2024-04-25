package com.hemanth.EcomV2.service;

import com.hemanth.EcomV2.entity.*;
import com.hemanth.EcomV2.repository.AddressRepo;
import com.hemanth.EcomV2.repository.OrdersRepo;
import com.hemanth.EcomV2.repository.ProductRepo;
import com.hemanth.EcomV2.repository.UserRepo;
import com.hemanth.EcomV2.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    AddressRepo addressRepo;


    public boolean placeOrder(OrderRequest orderRequest){

        User user=userRepo.getById(orderRequest.getUser_id());
        Product product=productRepo.getById(orderRequest.getProduct_id());
        Address address=addressRepo.getById(orderRequest.getAddress_id());
        Orders order=new Orders();
        order.setUser(user);
        order.setAddress(address);
        order.addProduct(product,orderRequest.getQuantity());
        order.setStatus(Status.placed);
        ordersRepo.save(order);
        return false;


    }
}
