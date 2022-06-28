package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.*;

import java.util.List;

public interface BasketService {
    Basket getBasketById(int id);

    List<BasketItem> getAllBasketItems(int basketId);

    void saveClient(Client client);

    void saveBasketItem(BasketItem basketItem);

    BasketItem getItemById(int id);

    BasketItem itemToBasketItem(Item item, int basketId);

    void saveBasket(Basket basket);

    List<Basket> getAllBaskets();

    void deleteBasketItem(int id);

    void dropAllItems(int basketId);

    Order getOrderByHostId(int hostId);

    void saveOrder(Order order);

    void saveOrderItem(OrderItem orderItem);

    List<BasketItem> getDoubleItems(int itemId, int hostId);
}