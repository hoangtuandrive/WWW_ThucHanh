package com.example.demo_www.services;

import com.example.demo_www.models.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> showAllCategory();
    Category findById(Long id);
    void delete(Long id);
}
