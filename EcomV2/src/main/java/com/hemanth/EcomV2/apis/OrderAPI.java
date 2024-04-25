package com.hemanth.EcomV2.apis;

import com.hemanth.EcomV2.requests.OrderRequest;
import com.hemanth.EcomV2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderAPI {
    @Autowired
    OrderService orderService;
    @PostMapping("/place")
    public boolean placeOrder(@RequestBody OrderRequest orderRequest){
       return  orderService.placeOrder(orderRequest);
    }
    public boolean placeOrder(int userId){
        return false;
    }
    public boolean cancelOrder(int userid,int orderId){
        return false;
    }
    public boolean returnOrder(int userid,int orderId){
        return false;
    }
    public boolean deliverOder(int userId,int orderId){
        return false;
    }
}
