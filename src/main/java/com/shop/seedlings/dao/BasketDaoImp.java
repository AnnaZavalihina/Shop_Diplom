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
    public List<BasketItem> getAllBasketItems(int basketId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("from BasketItem B where B.basket=%1$d",basketId);
        Query<BasketItem> query = session.createQuery(hql, BasketItem.class);
        List<BasketItem> basketItems = query.getResultList();
        return basketItems;
    }

    @Override
    public BasketItem itemToBasketItem(Item item, int basketId) {
        double price= item.getUnitPrice();
        Basket basket = getBasketById(basketId);
        BasketItem basketItem=new BasketItem(1,price,basket,item);
        return basketItem;
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

    @Override
    public int getBasketByIp(String ip) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("from Basket B where B.ip=\'%1$s\'",ip);
        Query<Basket> query = session.createQuery(hql, Basket.class);
        List<Basket> baskets = query.getResultList();
        Basket basket;int basketId;
        if(baskets!=null){basket = baskets.get(0);basketId=basket.getId();}
        else{basketId=0;}
        return basketId;
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
        List<Basket> baskets = query.getResultList();
        return baskets;
    }

    @Override
    public void deleteBasketItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        BasketItem item = session.load(BasketItem.class, id);
        if (item != null){
            session.delete(item);
        }
    }
}
