package com.hemanth.EcomV2.service;

import com.hemanth.EcomV2.entity.Product;
import com.hemanth.EcomV2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public boolean addAllProducts(List<Product>products){
        for(Product product:products)
        {
            productRepo.save(product);
        }
        return true;

    }
    public List<Product> getProductsByCategory(String category){
        return productRepo.findByCategory(category);
    }


}
