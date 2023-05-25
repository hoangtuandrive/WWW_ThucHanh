package com.example.demo_ck_www1.repositories;

import com.example.demo_ck_www1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
