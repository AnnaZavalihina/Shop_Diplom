package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImp implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public Order getOrderById(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, orderId);
    }
}
