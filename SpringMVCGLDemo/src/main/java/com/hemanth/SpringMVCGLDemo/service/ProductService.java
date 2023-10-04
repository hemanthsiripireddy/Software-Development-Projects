package com.hemanth.SpringMVCGLDemo.service;

import java.util.List;

import com.hemanth.SpringMVCGLDemo.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	Product getProductById(Integer id);
	void deleteProductById(Integer id);
	
	
}
