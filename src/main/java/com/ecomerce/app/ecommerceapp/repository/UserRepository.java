package com.ecomerce.app.ecommerceapp.repository;

import com.ecomerce.app.ecommerceapp.entity.UserEntity;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}

