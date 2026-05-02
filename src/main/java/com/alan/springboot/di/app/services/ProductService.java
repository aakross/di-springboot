package com.alan.springboot.di.app.services;

import com.alan.springboot.di.app.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);
}
