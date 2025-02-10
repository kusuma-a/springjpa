package com.example.Spring_task_demo.controller;

import com.example.Spring_task_demo.entity.Product;
import com.example.Spring_task_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "index";

    }
    @GetMapping("/addProduct")
    public String addProductForm(Model model){
        model.addAttribute("product",new Product());
        return "addProduct";
    }
    @PostMapping("/addProduct")
    public String addProductSubmit(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/";
    }
    @GetMapping("/displayProducts")
    public String displayProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "displayProducts";
    }
}
