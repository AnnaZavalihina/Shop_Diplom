package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketDaoImp implements BasketDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Basket getBasketById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Basket.class, id);
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    @Override
    public List<BasketItem> getAllBasketItems(int basketId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("from BasketItem B where B.basket=%1$d", basketId);
        Query<BasketItem> query = session.createQuery(hql, BasketItem.class);
        return query.getResultList();
    }

    @Override
    public BasketItem itemToBasketItem(Item item, int basketId) {
        double price = item.getUnitPrice();
        Basket basket = getBasketById(basketId);
        return new BasketItem(1, price, basket, item);
    }

    @Override
    public void saveBasketItem(BasketItem basketItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(basketItem);
    }

    @Override
    public BasketItem getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BasketItem.class, id);
    }

    @Override
    public void saveBasket(Basket basket) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(basket);
    }

    @Override
    public List<Basket> getAllBaskets() {
        Session session = sessionFactory.getCurrentSession();
        Query<Basket> query = session.createQuery("from Basket", Basket.class);
        return query.getResultList();
    }

    @Override
    public void deleteBasketItem(int itemId) {
        Session session = sessionFactory.getCurrentSession();
        int result = session.createQuery("delete BasketItem where id = :id").
                setString("id", String.valueOf(itemId)).executeUpdate();
    }

    @Override
    public void dropAllItems(int basketId) {
        Session session = sessionFactory.getCurrentSession();
        int result = session.createQuery("delete BasketItem where basket = :id").
                setString("id", String.valueOf(basketId)).executeUpdate();
    }

    @Override
    public Order getOrderByHostId(int hostId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("from Order O where O.clientId=%1$d", hostId);
        Query<Order> query = session.createQuery(hql, Order.class);
        List<Order> orderList;
        orderList = query.getResultList();
        return orderList.get(orderList.size() - 1);
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderItem);
    }

    @Override
    public List<BasketItem> getDoubleItems(int itemId, int hostId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("from BasketItem B where B.item=%1$d and B.basket=%2$d", itemId, hostId);
        Query<BasketItem> query = session.createQuery(hql, BasketItem.class);
        return query.getResultList();
    }
}
