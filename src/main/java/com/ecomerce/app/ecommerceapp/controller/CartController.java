package com.ecomerce.app.ecommerceapp.controller;

import com.ecomerce.app.ecommerceapp.api.CartApi;
import com.ecomerce.app.ecommerceapp.hateoas.CartRepresentaionModelAssembler;
import com.ecomerce.app.ecommerceapp.model.Cart;
import com.ecomerce.app.ecommerceapp.model.Item;
import com.ecomerce.app.ecommerceapp.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CartController implements CartApi {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    private final CartRepresentaionModelAssembler assmbler;
    CartService service;

    public CartController(CartRepresentaionModelAssembler assmbler, CartService service) {
        this.assmbler = assmbler;
        this.service = service;
    }



//    @Override
//    public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId , @Valid Item item)
//    {
//        log.info("Request for customer ID: {}\\nItem: {}",customerId,item);
//        return ok(Collections.EMPTY_LIST);
//    }

//    @Override
//    public Mono<ResponseEntity<Cart>> getCartByCustomerId(String customerId, ServerWebExchange exchange) {
//
//        //return service.getCartByCustomerId(customerId);
//
//    }



}
