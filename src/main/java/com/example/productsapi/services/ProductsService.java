package com.example.productsapi.services;

import com.example.productsapi.models.entities.Product;
import com.example.productsapi.models.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductsService {

    @Autowired
    private final ProductsRepo productsRepo;

    public ProductsService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public Product save(Product product){
        return productsRepo.save(product);
    }

    public Optional<Product> findOne(Long id){
        Optional<Product> byId = productsRepo.findById(id);
        if(byId.isEmpty()){
            throw new IllegalStateException("Id not found");
        }
        return productsRepo.findById(id);
    }

    public Iterable<Product> findAll(Product product){
        return productsRepo.findAll();
    }

    public void removeOne(Long id){
        Optional<Product> byId = productsRepo.findById(id);
        if(byId.isEmpty()){
            throw new IllegalStateException("Id "+ id + " Not found");
        }
        productsRepo.deleteById(id);
    }

    public List<Product> findByNameContains(String name){
        return productsRepo.findByNameContains(name);
    }
}



