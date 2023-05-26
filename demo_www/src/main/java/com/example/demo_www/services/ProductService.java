package com.example.demo_www.services;

import com.example.demo_www.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAllProduct();
    void save(Product product);
}
