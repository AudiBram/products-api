package com.example.productsapi.models.repos;

import com.example.productsapi.models.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends CrudRepository<Product, Long> {

    List<Product> findByNameContains(String name);

}
