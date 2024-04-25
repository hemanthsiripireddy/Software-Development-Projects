package com.hemanth.EcomV2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
   private User user;
@ElementCollection
@CollectionTable(name = "order_items",
        joinColumns = @JoinColumn(name = "order_product_Id"))
@MapKeyJoinColumn(name = "product_id")
@Column(name = "quantity")
   private Map<Product,Integer> products;

    private double totalPrice;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "address_id")
   private Address address;

    public boolean addProduct(Product product, int quantity){
        if(products==null){
            products=new HashMap<>();
        }
        products.put(product,quantity);
        totalPrice+=(product.getPrice()*quantity);
        return true;
    }
}
