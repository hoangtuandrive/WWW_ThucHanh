package com.example.demo_ck_www1.services;

import com.example.demo_ck_www1.models.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryServices {
    void save(Category category);

    List<Category> findAll();
    Optional<Category> findById(long id);

    void delete(Category category);
    boolean delete(long id);
}
