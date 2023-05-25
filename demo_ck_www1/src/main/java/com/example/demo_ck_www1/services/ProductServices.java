package com.example.demo_ck_www1.services;

import com.example.demo_ck_www1.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductServices {
    void save(Product product);

    List<Product> findAll();
    Optional<Product> findById(long id);

    void delete(Product product);
    boolean delete(long id);
}
