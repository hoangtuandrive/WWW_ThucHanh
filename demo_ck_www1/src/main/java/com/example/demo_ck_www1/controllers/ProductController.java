package com.example.demo_ck_www1.controllers;

import com.example.demo_ck_www1.models.Product;
import com.example.demo_ck_www1.services.CategoryServices;
import com.example.demo_ck_www1.services.ProductServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductServices productServices;
    private CategoryServices categoryServices;

    public ProductController(ProductServices productServices, CategoryServices categoryServices) {
        this.productServices = productServices;
        this.categoryServices = categoryServices;
    }

    @GetMapping({"","/list"})
    public ModelAndView findAllProducts() {
        ModelAndView model = new ModelAndView();
        model.addObject("products", productServices.findAll());
        model.setViewName("product_listing");
        return model;
    }

    @PostMapping("/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productServices.save(product);
        modelAndView.setViewName("redirect:/products");
        return modelAndView;
    }

    @GetMapping("/showAddForm")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories", categoryServices.findAll());
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("add_product_form");
        return modelAndView;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productServices.findById(id).get();
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categoryServices.findAll());
        modelAndView.setViewName("add_product_form");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProduct(long id) {
        ModelAndView model = new ModelAndView();
        Product product = productServices.findById(id).get();
        productServices.delete(product);
        model.setViewName("redirect:/products");
        return model;
    }
}
