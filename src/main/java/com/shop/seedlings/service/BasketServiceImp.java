package com.shop.seedlings.service;

import com.shop.seedlings.dao.BasketDao;
import com.shop.seedlings.domain.entity.Address;
import com.shop.seedlings.domain.entity.Basket;
import com.shop.seedlings.domain.entity.BasketItem;
import com.shop.seedlings.domain.entity.Client;
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
    public Address getAddressById(int id) {
        return basketDao.getAddressById(id);
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
}
