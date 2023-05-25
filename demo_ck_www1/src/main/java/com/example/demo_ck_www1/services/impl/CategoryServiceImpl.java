package com.example.demo_ck_www1.services.impl;

import com.example.demo_ck_www1.models.Category;
import com.example.demo_ck_www1.repositories.CatagoryRepository;
import com.example.demo_ck_www1.services.CategoryServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServices {
    private final CatagoryRepository catagoryRepository;

    public CategoryServiceImpl(CatagoryRepository catagoryRepository) {
        this.catagoryRepository = catagoryRepository;
    }

    @Override
    public void save(Category category) {
        catagoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return catagoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {
        return catagoryRepository.findById(id);
    }

    @Override
    public void delete(Category category) {
        catagoryRepository.delete(category);
    }

    @Override
    public boolean delete(long id) {
        Optional<Category> op = catagoryRepository.findById(id);
        if(op.isPresent()){
            Category category = op.get();
            delete(category);
            return true;
        }
        return false;
    }
}
