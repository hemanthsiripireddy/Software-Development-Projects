package com.hemanth.service;

import com.hemanth.entity.Product;

public interface ProductService {
	
	public void getProductById(int id);
	public void getAllProducts();
	public void saveProduct(Product product);
	public void updateProduct(Product product);
	

}
