package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketDaoImp implements BasketDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Basket getBasketById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Basket basket = session.get(Basket.class, id);
        return basket;
    }

    @Override
    public Client getClientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class, id);
        return client;
    }

    @Override
    public Address getAddressById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Address address = session.get(Address.class, id);
        return address;
    }

    @Override
    public List<BasketItem> getAllBasketItems(int basketId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("from BasketItem B where B.basket=%1$d",basketId);
        Query<BasketItem> query = session.createQuery(hql, BasketItem.class);
        List<BasketItem> basketItems = query.getResultList();
        return basketItems;
    }

    @Override
    public void saveBasketItem(BasketItem basketItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(basketItem);
    }

    @Override
    public BasketItem getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        BasketItem item = session.get(BasketItem.class, id);
        return item;
    }
}
