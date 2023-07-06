package com.ecomerce.app.ecommerceapp.service;

import com.ecomerce.app.ecommerceapp.entity.CartEntity;
import com.ecomerce.app.ecommerceapp.entity.ItemEntity;
import com.ecomerce.app.ecommerceapp.exceptions.GenericAlreadyExistsException;
import com.ecomerce.app.ecommerceapp.model.Item;
import com.ecomerce.app.ecommerceapp.repository.CartRepository;
import com.ecomerce.app.ecommerceapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CartServiceImpl  implements CartService{
    private CartRepository repository;
    private UserRepository userRepo;
    private ItemService itemService;

    public CartServiceImpl(CartRepository repository, UserRepository userRepo, ItemService itemService) {
        this.repository = repository;
        this.userRepo = userRepo;
        this.itemService = itemService;
    }

    @Override
    public List<Item> addCartItemsByCustomerId(String customerId, Item item) {
        /*get the cat by customer id
         */
        CartEntity entity=getCartByCustomerId(customerId);
        /*
        then  find if the item already exists in cart or not
         */
        long count=entity.getItems().stream().filter(i->
                i.getProduct().getId().equals(
                UUID.fromString(item.getId()))).count();
        /*
        if the count is greater than 1  the customer has to update the cart not add
         */
        if (count > 0) {
            throw new GenericAlreadyExistsException(
                    String.format("Item with Id (%s) already exists.  You can update it.", item.getId()));
        }
        /*
        have to convert the item model to entity
         */
        entity.getItems().add(itemService.toEntity(item));
  /*
  retun the converted entity items to model

   */
        return itemService.toModelList(
                repository.save(entity).getItems());
    }

    @Override
    public List<Item> addOrReplaceItemByCustomerId(String customerId, Item item) {
       CartEntity entity=getCartByCustomerId(customerId);
       List<ItemEntity> items= Objects.nonNull(entity.getItems()) ? entity.getItems(): Collections.emptyList();
        AtomicBoolean itemExists = new AtomicBoolean(false);
    /*
       check if the item is exist or not if exist plus the quantity and add the price and set flag as its true
     */
        items.forEach(i -> {
            if (i.getProduct().getId()
                    .equals(UUID.fromString(item.getId()))) {
                i.setQuantity(item.getQuantity()).setPrice(i.getPrice());
                itemExists.set(true);
            }});
       /*
       if the flag is false add it to the items
        */
        if (!itemExists.get()) {
            items.add(itemService.toEntity(item));
        }

        return itemService.
                toModelList(repository.save(entity).getItems());
    }

    @Override
    public void deleteCart(String customerId) {

    }

    @Override
    public void deleteItemFromCart(String customerId, String itemId) {

    }

    @Override
    public CartEntity getCartByCustomerId(String customerId) {
        return null;
    }

    @Override
    public List<Item> getCartItemsByCustomerId(String customerId) {
        return null;
    }

    @Override
    public Item getCartItemsByItemId(String customerId, String itemId) {
        return null;
    }
}
