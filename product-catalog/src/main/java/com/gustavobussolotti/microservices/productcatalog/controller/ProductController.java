package com.gustavobussolotti.microservices.productcatalog.controller;


import com.gustavobussolotti.microservices.productcatalog.model.Product;
import com.gustavobussolotti.microservices.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insert(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> find(@PathVariable Long productId){

        return productRepository.findById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}
