package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.Address;
import com.shop.seedlings.domain.entity.Basket;
import com.shop.seedlings.domain.entity.BasketItem;
import com.shop.seedlings.domain.entity.Client;

import java.util.List;

public interface BasketService {
    Basket getBasketById(int id);
    List<BasketItem> getAllBasketItems(int basketId);
    Client getClientById(int id);
    Address getAddressById(int id);
    void saveBasketItem(BasketItem basketItem);
    public BasketItem getItemById(int id);
}