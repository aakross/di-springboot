package com.alan.springboot.di.app.services;

import com.alan.springboot.di.app.models.Product;
import com.alan.springboot.di.app.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    //    private ProductRepositoryImpl repository = new ProductRepositoryImpl();
    @Autowired
    private ProductRepositoryImpl repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
////            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
////            p.setPrice();
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
