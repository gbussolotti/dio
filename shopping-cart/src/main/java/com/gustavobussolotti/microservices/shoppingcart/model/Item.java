package com.gustavobussolotti.microservices.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Integer amount;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "cart", referencedColumnName = "id")
    @ManyToOne(optional = false)    //Não permite null no campo de relacionamento. Força a ter dados na chave estrangeira
    private Cart cart;

}
