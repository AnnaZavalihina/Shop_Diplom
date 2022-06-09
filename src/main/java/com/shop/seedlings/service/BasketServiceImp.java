package com.shop.seedlings.service;

import com.shop.seedlings.dao.BasketDao;
import com.shop.seedlings.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasketServiceImp implements BasketService{
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
    public Client getClientById(int id) {
        return basketDao.getClientById(id);
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
        return basketDao.itemToBasketItem(item,basketId);
    }

    @Override
    @Transactional
    public int getBasketByIp(String ip) {
        return basketDao.getBasketByIp(ip);
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
    public void deleteBasketItem(int id) {
        basketDao.deleteBasketItem(id);
    }
}
