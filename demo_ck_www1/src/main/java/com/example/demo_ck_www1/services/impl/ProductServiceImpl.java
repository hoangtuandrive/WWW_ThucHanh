package com.example.demo_ck_www1.services.impl;

import com.example.demo_ck_www1.models.Product;
import com.example.demo_ck_www1.repositories.ProductRepository;
import com.example.demo_ck_www1.services.ProductServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServices {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public boolean delete(long id) {
        Optional<Product> op = productRepository.findById(id);
        if(op.isPresent()){
            Product product = op.get();
            delete(product);
            return true;
        }
        return false;
    }
}
