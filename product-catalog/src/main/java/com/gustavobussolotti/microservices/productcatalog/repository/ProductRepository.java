package com.gustavobussolotti.microservices.productcatalog.repository;

import com.gustavobussolotti.microservices.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
