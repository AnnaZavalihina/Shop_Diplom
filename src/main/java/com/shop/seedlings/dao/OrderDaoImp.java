package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Item;
import com.shop.seedlings.domain.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("from Order", Order.class);
        List<Order> allOrders = query.getResultList();
        return allOrders;
    }

    @Override
    public List<Order> getAllMadeOrders(String made) {
        Session session = sessionFactory.getCurrentSession();
        String hql = String.format("FROM Order as O WHERE O.status=\'%1$s\' ORDER BY O.date ASC", made);
        Query<Order> query = session.createQuery(hql, Order.class);
        List<Order> allMadeOrders = query.getResultList();
        return allMadeOrders;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public Order getOrderById(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        return order;
    }
}
