package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;

import java.util.List;

public interface BasketDao {
    Basket getBasketById(int id);
    Client getClientById(int id);

    List<BasketItem> getAllBasketItems(int basketId);
    BasketItem itemToBasketItem(Item item,int basketId);
    void saveBasketItem(BasketItem basketItem);
    BasketItem getItemById(int id);

    int getBasketByIp(String ip);

    void saveBasket(Basket basket);

    List<Basket> getAllBaskets();
    void deleteBasketItem(int id);
}