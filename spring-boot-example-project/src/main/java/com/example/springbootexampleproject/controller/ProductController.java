package com.example.springbootexampleproject.controller;

import com.example.springbootexampleproject.entity.Product;
import com.example.springbootexampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @Cacheable(value = "PRODUCT", key="#id")
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) throws InterruptedException {
        Thread.sleep(3000);
        return service.getProductById(id);
    }

}

