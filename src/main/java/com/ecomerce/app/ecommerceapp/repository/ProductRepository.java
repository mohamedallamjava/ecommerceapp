package com.ecomerce.app.ecommerceapp.repository;

import com.ecomerce.app.ecommerceapp.entity.ProductEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {

}

