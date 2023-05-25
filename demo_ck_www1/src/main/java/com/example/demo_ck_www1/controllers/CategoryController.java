package com.example.demo_ck_www1.controllers;

import com.example.demo_ck_www1.models.Category;
import com.example.demo_ck_www1.services.CategoryServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping({"","/list"})
    public ModelAndView findAllCategories() {
        ModelAndView model = new ModelAndView();
        model.addObject("categories", categoryServices.findAll());
        model.setViewName("category_listing");
        return model;
    }

    @PostMapping("/saveCategory")
    public ModelAndView saveCategory(@ModelAttribute Category category) {
        ModelAndView modelAndView = new ModelAndView();
        categoryServices.save(category);
        modelAndView.setViewName("redirect:/categories");
        return modelAndView;
    }

    @GetMapping("/showAddForm")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category", new Category());
        modelAndView.setViewName("add_category_form");
        return modelAndView;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryServices.findById(id).get();
        modelAndView.addObject("category", category);
        modelAndView.setViewName("add_category_form");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProduct(long id) {
        ModelAndView model = new ModelAndView();
        Category category = categoryServices.findById(id).get();
        categoryServices.delete(category);
        model.setViewName("redirect:/categories");
        return model;
    }
}
