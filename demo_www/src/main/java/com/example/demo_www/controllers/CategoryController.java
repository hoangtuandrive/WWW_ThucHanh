package com.example.demo_www.controllers;

import com.example.demo_www.models.Category;
import com.example.demo_www.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ModelAndView showAllCategory() {
        ModelAndView model = new ModelAndView();
        model.addObject("categories",categoryService.showAllCategory());
        model.setViewName("category_listing");
        return model;
    }

    @GetMapping("showAddForm")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category", new Category());
        modelAndView.setViewName("add_category_form");
        return modelAndView;
    }

    @PostMapping("/saveCategory")
    public ModelAndView saveCategory(@ModelAttribute Category category) {
        ModelAndView modelAndView = new ModelAndView();
        categoryService.save(category);
        modelAndView.setViewName("redirect:/categories");
        return modelAndView;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryService.findById(id);
        modelAndView.addObject("category",category);
        modelAndView.setViewName("add_category_form");
        return modelAndView;
    }

    @GetMapping("/deleteCategory")
    public ModelAndView deleteCategory(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        categoryService.delete(id);
        modelAndView.setViewName("redirect:/categories");
        return modelAndView;
    }
}
