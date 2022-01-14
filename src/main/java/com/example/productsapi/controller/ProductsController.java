package com.example.productsapi.controller;

import com.example.productsapi.dto.ResponseData;
import com.example.productsapi.models.entities.Product;
import com.example.productsapi.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors) {
        ResponseData<Product> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus("FAILED");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus("SUCCESS");
        responseData.setPayload(productsService.save(product));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(path = "/{findOne}")
    public Optional<Product> findOne(@PathVariable("findOne") Long id) {
        return productsService.findOne(id);
    }

    @GetMapping
    public Iterable<Product> findAll(Product product) {
        return productsService.findAll(product);
    }

    @DeleteMapping(path = "/{deleteId}")
    public void removeOne(@PathVariable("deleteId") Long id) {
        productsService.removeOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors) {
        ResponseData<Product> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus("FAILED");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus("SUCCESS");
        responseData.setPayload(productsService.save(product));
        return ResponseEntity.ok(responseData);
    }
}
