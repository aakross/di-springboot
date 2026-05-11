package com.alan.springboot.di.app.services;

import com.alan.springboot.di.app.models.Product;
import com.alan.springboot.di.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;
    //    private ProductRepositoryImpl repository = new ProductRepositoryImpl();
//    @Autowired
//    @Qualifier("productFoo")
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    //    @Autowired
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
////            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
////            p.setPrice();
//            Product newProd = (Product) p.clone();
//            newProd.setPrice(priceImp.longValue());
//            return newProd;
            p.setPrice(priceImp.longValue());
            return p;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }


}
