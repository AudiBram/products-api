package com.example.productsapi.controller;

import com.example.productsapi.models.entities.Product;
import com.example.productsapi.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/products")
public class ProductsController {

    @Autowired
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productsService.save(product);
    }

    @GetMapping(path = "/{findOne}")
    public Optional<Product> findOne(@PathVariable("findOne") Long id){
        return productsService.findOne(id);
    }

    @GetMapping
    public Iterable<Product> findAll(Product product){
        return productsService.findAll(product);
    }

    @DeleteMapping(path = "/{deleteId}")
    public void removeOne(@PathVariable("deleteId") Long id){
        productsService.removeOne(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productsService.save(product);
    }

}
