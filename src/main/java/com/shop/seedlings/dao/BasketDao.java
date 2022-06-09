package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;

import java.util.List;

public interface BasketDao {
    Basket getBasketById(int id);

    Client getClientById(int id);

    void saveClient(Client client);
    boolean checkClient(Client client);

    List<BasketItem> getAllBasketItems(int basketId);

    BasketItem itemToBasketItem(Item item, int basketId);

    void saveBasketItem(BasketItem basketItem);

    BasketItem getItemById(int id);

    void saveBasket(Basket basket);

    List<Basket> getAllBaskets();

    void deleteBasketItem(int id);

    void dropAllItems(int basketId);

    Order getOrderByHostId(int hostId);
    void saveOrder(Order order);
}