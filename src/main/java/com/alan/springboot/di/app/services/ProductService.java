package com.alan.springboot.di.app.services;

import com.alan.springboot.di.app.models.Product;
import com.alan.springboot.di.app.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
//            p.setPrice();
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
