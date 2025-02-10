package com.example.Spring_task_demo.service;

import com.example.Spring_task_demo.entity.Product;
import com.example.Spring_task_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(String category){
        return productRepository.findByCategory(category);
    }
}
