package com.alan.springboot.di.app.repositories;

import com.alan.springboot.di.app.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria Corsair 2", 300L),
                new Product(2L, "Cpu Intel core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 80L),
                new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

//    public List<Product> findAll() {
//        return data;
//    }
//
//    public Product findById(Long id) {
//        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//    }

}
