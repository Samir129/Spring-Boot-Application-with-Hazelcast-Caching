package com.example.springbootexampleproject.service;

import com.example.springbootexampleproject.entity.Product;
import com.example.springbootexampleproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }


    @Cacheable(value = "PRODUCT", key="#id")
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

}

