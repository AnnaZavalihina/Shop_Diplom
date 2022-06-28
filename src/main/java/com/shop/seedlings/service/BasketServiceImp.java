package com.shop.seedlings.service;

import com.shop.seedlings.dao.BasketDao;
import com.shop.seedlings.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasketServiceImp implements BasketService {
    @Autowired
    private BasketDao basketDao;

    @Override
    @Transactional
    public Basket getBasketById(int id) {
        return basketDao.getBasketById(id);
    }

    @Override
    @Transactional
    public List<BasketItem> getAllBasketItems(int basketId) {
        return basketDao.getAllBasketItems(basketId);
    }


    @Override
    @Transactional
    public void saveClient(Client client) {
        basketDao.saveClient(client);
    }


    @Override
    @Transactional
    public void saveBasketItem(BasketItem basketItem) {
        basketDao.saveBasketItem(basketItem);
    }

    @Override
    @Transactional
    public BasketItem getItemById(int id) {
        return basketDao.getItemById(id);
    }

    @Override
    @Transactional
    public BasketItem itemToBasketItem(Item item, int basketId) {
        return basketDao.itemToBasketItem(item, basketId);
    }


    @Override
    @Transactional
    public void saveBasket(Basket basket) {
        basketDao.saveBasket(basket);
    }

    @Override
    @Transactional
    public List<Basket> getAllBaskets() {
        return basketDao.getAllBaskets();
    }

    @Override
    @Transactional
    public void deleteBasketItem(int id) {
        basketDao.deleteBasketItem(id);
    }

    @Override
    @Transactional
    public void dropAllItems(int basketId) {
        basketDao.dropAllItems(basketId);
    }

    @Override
    @Transactional
    public Order getOrderByHostId(int hostId) {
        return basketDao.getOrderByHostId(hostId);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        basketDao.saveOrder(order);
    }

    @Override
    @Transactional
    public void saveOrderItem(OrderItem orderItem) {
        basketDao.saveOrderItem(orderItem);
    }

    @Override
    @Transactional
    public List<BasketItem> getDoubleItems(int itemId, int hostId) {
        return basketDao.getDoubleItems(itemId, hostId);
    }
}
