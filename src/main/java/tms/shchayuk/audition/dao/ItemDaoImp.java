package tms.shchayuk.audition.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tms.shchayuk.audition.entity.*;

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
    public void saveItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void deleteItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.load(Item.class, id);
        if (item != null){
            session.delete(item);
        }
    }
}
