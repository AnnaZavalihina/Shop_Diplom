package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImp implements ShopDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Info getInfo() {
        Session session = sessionFactory.getCurrentSession();
        int id = 1;
        Info info = session.get(Info.class, id);
        return info;
    }

    @Override
    public List<PickupAddress> getAllPickupAddresses() {
        Session session = sessionFactory.getCurrentSession();
        Query<PickupAddress> query = session.createQuery("from PickupAddress", PickupAddress.class);
        List<PickupAddress> allPickupAddresses = query.getResultList();
        return allPickupAddresses;
    }

}