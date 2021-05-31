package com.gustavobussolotti.microservices.shoppingcart.repository;

import com.gustavobussolotti.microservices.shoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByIdClient(Long idClient);
}
