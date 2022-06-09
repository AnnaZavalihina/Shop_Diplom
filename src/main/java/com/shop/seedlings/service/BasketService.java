package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.*;

import java.util.List;

public interface BasketService {
    Basket getBasketById(int id);
    List<BasketItem> getAllBasketItems(int basketId);
    Client getClientById(int id);
    void saveClient(Client client);
    boolean checkClient(Client client);

    void saveBasketItem(BasketItem basketItem);
     BasketItem getItemById(int id);
     BasketItem itemToBasketItem(Item item, int basketId);

    void saveBasket(Basket basket);
    List<Basket> getAllBaskets();
    void  deleteBasketItem(int id);
    void dropAllItems(int basketId);

    Order getOrderByHostId(int hostId);
    void saveOrder(Order order);
    void saveOrderItem(OrderItem orderItem);
}