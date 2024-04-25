package com.hemanth.EcomV2.testData;

import com.hemanth.EcomV2.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    public static List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setDescription("High-performance laptop with SSD storage");
        product1.setCategory("Electronics");
        product1.setPrice(1200.00);
        product1.setQuantity(10);
        products.add(product1);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setDescription("Latest model with advanced camera features");
        product2.setCategory("Electronics");
        product2.setPrice(800.00);
        product2.setQuantity(15);
        products.add(product2);

        Product product3 = new Product();
        product3.setName("Wireless Headphones");
        product3.setDescription("Noise-cancelling headphones with long battery life");
        product3.setCategory("Electronics");
        product3.setPrice(150.00);
        product3.setQuantity(20);
        products.add(product3);

        Product product4 = new Product();
        product4.setName("Smart Watch");
        product4.setDescription("Fitness tracker with heart rate monitor");
        product4.setCategory("Wearable");
        product4.setPrice(100.00);
        product4.setQuantity(12);
        products.add(product4);

        Product product5 = new Product();
        product5.setName("Coffee Maker");
        product5.setDescription("Automatic coffee machine for home use");
        product5.setCategory("Home Appliances");
        product5.setPrice(80.00);
        product5.setQuantity(8);
        products.add(product5);

        Product product6 = new Product();
        product6.setName("Bluetooth Speaker");
        product6.setDescription("Portable speaker with waterproof design");
        product6.setCategory("Electronics");
        product6.setPrice(50.00);
        product6.setQuantity(25);
        products.add(product6);

        Product product7 = new Product();
        product7.setName("Dress Shirt");
        product7.setDescription("Formal shirt for men");
        product7.setCategory("Clothing");
        product7.setPrice(30.00);
        product7.setQuantity(30);
        products.add(product7);

        Product product8 = new Product();
        product8.setName("Running Shoes");
        product8.setDescription("Sports shoes for running");
        product8.setCategory("Footwear");
        product8.setPrice(60.00);
        product8.setQuantity(18);
        products.add(product8);

        Product product9 = new Product();
        product9.setName("Desk Lamp");
        product9.setDescription("Adjustable LED lamp for study or work");
        product9.setCategory("Home Accessories");
        product9.setPrice(25.00);
        product9.setQuantity(22);
        products.add(product9);

        Product product10 = new Product();
        product10.setName("Backpack");
        product10.setDescription("Stylish backpack with multiple compartments");
        product10.setCategory("Bags");
        product10.setPrice(40.00);
        product10.setQuantity(14);
        products.add(product10);

        // Add more products as needed

        return products;
    }
}
