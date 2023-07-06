package com.ecomerce.app.ecommerceapp.repository;

import com.ecomerce.app.ecommerceapp.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, UUID> {
}
