package com.example.demo_www.services.impl;

import com.example.demo_www.models.Product;
import com.example.demo_www.repositories.ProductRepository;
import com.example.demo_www.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> showAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
