package com.hemanth.SpringMVCGLDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.hemanth.SpringMVCGLDemo.entity.Product;
import com.hemanth.SpringMVCGLDemo.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return saveProduct(product);
	}

	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}

}
