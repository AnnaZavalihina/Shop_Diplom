package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.*;

import java.util.List;

public interface BasketService {
    Basket getBasketById(int id);
    List<BasketItem> getAllBasketItems(int basketId);
    Client getClientById(int id);
    void saveBasketItem(BasketItem basketItem);
     BasketItem getItemById(int id);
     BasketItem itemToBasketItem(Item item, int basketId);
    int getBasketByIp(String ip);
    void saveBasket(Basket basket);
    List<Basket> getAllBaskets();
    void  deleteBasketItem(int id);
}