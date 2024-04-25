package com.hemanth.EcomV2.apis;

import com.hemanth.EcomV2.entity.Product;
import com.hemanth.EcomV2.requests.ProductRequest;
import com.hemanth.EcomV2.requests.UserRequest;
import com.hemanth.EcomV2.service.ProductService;
import com.hemanth.EcomV2.testData.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductAPI {
    @Autowired
    ProductService productService;
    @Autowired
    UserAPI userAPI;

    @PostMapping("/save")
    public boolean add(@RequestBody  ProductRequest product){
        if(userAPI.login(new UserRequest(product.getUserName(),product.getPassword()))){
            List<Product>products= ProductData.getSampleProducts();
            productService.addAllProducts(products);
            return true;

        }
        return false;




        //return true;
    }
    public boolean delete(int id){
        return false;

    }
    public boolean update(int id,ProductRequest product){
        return false;
    }
@GetMapping("/get")
    public List<Product> getProductsByCategory(@RequestParam String category){
        return productService.getProductsByCategory(category);

    }
}
