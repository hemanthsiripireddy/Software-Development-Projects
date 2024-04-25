package com.hemanth.EcomV2.entity;

import jakarta.persistence.*;

import java.util.Map;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;
    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private User user;
    @ElementCollection
    @CollectionTable(name = "cart_items",
            joinColumns = @JoinColumn(name = "cart_product_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product,Integer> products;
    private double totalPrice;

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean updateQuantity(int productId,int quantity){
        for(Product product:products.keySet()){
            if(product.getProductId()==productId){
                product.setQuantity(quantity);
                return true;
            }
        }
        return false;

    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public boolean add(Product product,int quantity){
        //Product product;
        if(!products.containsKey(product)){
            products.put(product,quantity);

            this.totalPrice+=(product.getPrice()*quantity);
            return true;

        }
        return false;

    }
}
