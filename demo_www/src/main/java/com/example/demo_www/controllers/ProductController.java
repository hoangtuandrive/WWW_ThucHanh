package com.example.demo_www.controllers;

import com.example.demo_www.models.Product;
import com.example.demo_www.services.CategoryService;
import com.example.demo_www.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ModelAndView showAllProuct() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.showAllProduct();
        modelAndView.addObject("products",products);
        modelAndView.setViewName("product_listing");
        return modelAndView;
    }

    @GetMapping("/addFormProduct")
    public ModelAndView showAddFormProduct() {
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("product", new Product());
        modelView.addObject("categories", categoryService.showAllCategory());
        modelView.setViewName("add_form_product");
        return modelView;
    }

    @PostMapping("/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        ModelAndView modelView = new ModelAndView();
        productService.save(product);
        modelView.setViewName("redirect:/products");
        return modelView;
    }
}
