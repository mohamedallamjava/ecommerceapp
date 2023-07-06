package com.ecomerce.app.ecommerceapp.controller;


import com.ecomerce.app.ecommerceapp.api.ProductApi;
import com.ecomerce.app.ecommerceapp.hateoas.ProductRepresentationModelAssembler;
import com.ecomerce.app.ecommerceapp.model.Product;
import com.ecomerce.app.ecommerceapp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
@RestController
public class ProductController implements ProductApi {

  private ProductService service;
  private final ProductRepresentationModelAssembler assembler;

  public ProductController(ProductService service, ProductRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }
//
//  @Override
//  public Mono<ResponseEntity<Product>> getProduct(String id) {
//    return service.getProduct(id).map(assembler::toModel).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//  }

//  @Override
//  public ResponseEntity<List<Product>> queryProducts(@Valid String tag, @Valid String name,
//      @Valid Integer page, @Valid Integer size) {
//    return ok(assembler.toListModel(service.getAllProducts()));
//  }
}
