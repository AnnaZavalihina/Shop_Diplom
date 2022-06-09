package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Subtype;
import com.shop.seedlings.domain.entity.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.seedlings.domain.entity.Item;

import java.util.*;

@Repository
public class ItemDaoImp implements ItemDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Item getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.get(Item.class, id);
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        Session session = sessionFactory.getCurrentSession();
        Query<Item> query = session.createQuery("from Item", Item.class);
        List<Item> allItems = query.getResultList();
        return allItems;
    }

    @Override
    public List<Item> getAllSubtypeItems(int subtypeId) {
        Session session = sessionFactory.getCurrentSession();
        String hql=String.format("FROM Item as I WHERE I.subtype = %1$d ORDER BY I.name ASC", subtypeId);
        Query<Item> query = session.createQuery(hql, Item.class);
        List<Item> allSubtypeItems = query.getResultList();
        return allSubtypeItems;
    }

    @Override
    public List<Item> getAllTypeItems(int typeId) {
        Session session = sessionFactory.getCurrentSession();
        String hql=String.format("FROM Item as I WHERE I.subtype.type=%1$d ORDER BY I.name ASC", typeId);
        Query<Item> query = session.createQuery(hql, Item.class);
        List<Item> allTypeItems = query.getResultList();
        return allTypeItems;
    }

    @Override
    public void saveItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(item);
    }

    @Override
    public void deleteItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.load(Item.class, id);
        if (item != null){
            session.delete(item);
        }
    }

    @Override
    public List<Item> getAllDiscountItems() {
        Session session = sessionFactory.getCurrentSession();
        Query<Item> query = session.createQuery("FROM Item I WHERE I.status = 'true'", Item.class);
        List<Item> allDiscountItems = query.getResultList();
        return allDiscountItems;
    }

    @Override
    public List<Subtype> getSubtypes() {
        Session session = sessionFactory.getCurrentSession();
        Query<Subtype> query = session.createQuery("FROM Subtype", Subtype.class);
        List<Subtype> allSubtypes = query.getResultList();
        return allSubtypes;
    }

    @Override
    public List<Type> getAllTypes() {
        Session session = sessionFactory.getCurrentSession();
        Query<Type> query = session.createQuery("FROM Type", Type.class);
        List<Type> allTypes = query.getResultList();
        return allTypes;
    }

    @Override
    public List<Subtype> getAllSubtypes(int typeId) {
        Session session = sessionFactory.getCurrentSession();
        String hql=String.format("FROM Subtype as S WHERE S.type=%1$d ORDER BY S.name ASC", typeId);
        Query<Subtype> query = session.createQuery(hql, Subtype.class);
        List<Subtype> allSubtypes = query.getResultList();
        return allSubtypes;
    }

    @Override
    public Type getTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Type type = session.get(Type.class, id);
        return type;
    }

    @Override
    public Subtype getSubtypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Subtype subtype = session.get(Subtype.class, id);
        return subtype;
    }
}
