package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;
import org.hibernate.Session;

import java.util.List;

public interface BasketDao {
    Basket getBasketById(int id);
    Client getClientById(int id);
    Address getAddressById(int id);
    List<BasketItem> getAllBasketItems(int basketId);
    void itemToBasketItem(Item item);
    void addItemInBasket(BasketItem item);
    void saveBasketItem(BasketItem basketItem);
    BasketItem getItemById(int id);
}