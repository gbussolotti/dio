package com.gustavobussolotti.microservices.cart.controller;

import com.gustavobussolotti.microservices.cart.model.Cart;
import com.gustavobussolotti.microservices.cart.model.Item;
import com.gustavobussolotti.microservices.cart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository repository;

    @PostMapping("/{idClient}")
    public Cart addItem(@PathVariable Long idClient, @RequestBody Item item){
        Optional<Cart> savedCart = repository.findByIdClient(idClient);
        Cart cart = null;
        if(!savedCart.isPresent()){
            cart = repository.save(new Cart());
        }else{
            cart = savedCart.get();
        }
        cart.setIdClient(idClient);
        item.setCart(cart);
        cart.getItems().add(item);
        return repository.save(cart);

    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> find(@PathVariable Long cartId){

        return repository.findById(cartId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Cart> list(){
        return repository.findAll();
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> remover(@PathVariable Long cartId) {
        if (!repository.existsById(cartId)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(cartId);
        //catalog.excluir(cartId);
        return ResponseEntity.noContent().build();	//Retornará um 204 (Sucesso sem resposta)
    }


}
