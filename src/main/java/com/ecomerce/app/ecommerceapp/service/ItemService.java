package com.ecomerce.app.ecommerceapp.service;

import com.ecomerce.app.ecommerceapp.entity.ItemEntity;
import com.ecomerce.app.ecommerceapp.model.Item;

import java.util.List;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface ItemService {

  ItemEntity toEntity(Item m);

  List<ItemEntity> toEntityList(List<Item> items);

  Item toModel(ItemEntity e);

  List<Item> toModelList(List<ItemEntity> items);
}
