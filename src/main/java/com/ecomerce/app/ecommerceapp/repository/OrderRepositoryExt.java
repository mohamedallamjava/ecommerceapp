package com.ecomerce.app.ecommerceapp.repository;

import com.ecomerce.app.ecommerceapp.entity.OrderEntity;
import com.ecomerce.app.ecommerceapp.model.NewOrder;

import java.util.Optional;

public interface OrderRepositoryExt {
    Optional<OrderEntity> insert(NewOrder m);
}
